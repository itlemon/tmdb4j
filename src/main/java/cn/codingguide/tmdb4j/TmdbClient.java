package cn.codingguide.tmdb4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.codingguide.tmdb4j.api.AccountApi;
import cn.codingguide.tmdb4j.api.AuthenticationApi;
import cn.codingguide.tmdb4j.api.MoviesApi;
import cn.codingguide.tmdb4j.auth.AuthMethod;
import cn.codingguide.tmdb4j.exception.TmdbApiException;
import cn.codingguide.tmdb4j.exception.TmdbException;
import cn.codingguide.tmdb4j.exception.TmdbHttpException;
import cn.codingguide.tmdb4j.exception.TmdbIOException;
import cn.codingguide.tmdb4j.exception.TmdbSessionException;
import cn.codingguide.tmdb4j.interceptor.ApiKeyInterceptor;
import cn.codingguide.tmdb4j.interceptor.SessionInterceptor;
import cn.codingguide.tmdb4j.model.Account;
import cn.codingguide.tmdb4j.model.GuestSessionResponse;
import cn.codingguide.tmdb4j.model.LoginRequest;
import cn.codingguide.tmdb4j.model.Movie;
import cn.codingguide.tmdb4j.model.RequestTokenResponse;
import cn.codingguide.tmdb4j.model.SessionResponse;
import cn.codingguide.tmdb4j.session.SessionKeyProvider;
import cn.codingguide.tmdb4j.session.SessionStore;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 主入口，构建 Retrofit 实例
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class TmdbClient {

    private final MoviesApi moviesApi;
    private final AccountApi accountApi;
    private final AuthenticationApi authenticationApi;

    @Getter
    private final SessionStore sessionStore;
    @Getter
    private final SessionKeyProvider sessionKeyProvider;

    private TmdbClient(Builder builder) {
        this.sessionStore = builder.sessionStore;
        this.sessionKeyProvider = builder.sessionKeyProvider;

        // 构建 OkHttpClient
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder()
                .addInterceptor(new ApiKeyInterceptor(builder.apiKey, builder.bearerToken, builder.authMethod))
                .addInterceptor(new SessionInterceptor(sessionStore, sessionKeyProvider))
                .connectTimeout(builder.connectTimeout, TimeUnit.SECONDS)
                .readTimeout(builder.readTimeout, TimeUnit.SECONDS);

        if (builder.loggingInterceptor != null) {
            httpBuilder.addInterceptor(builder.loggingInterceptor);
        }

        OkHttpClient okHttpClient = httpBuilder.build();

        // 构建 Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建 API 实例
        this.moviesApi = retrofit.create(MoviesApi.class);
        this.accountApi = retrofit.create(AccountApi.class);
        this.authenticationApi = retrofit.create(AuthenticationApi.class);
    }

    // ==================== 会话管理接口 ====================

    /**
     * 创建正式用户会话（三步认证），并自动保存到 SessionStore。
     *
     * @param username TMDB 用户名
     * @param password TMDB 密码
     * @return sessionId
     */
    public String login(String username, String password) throws TmdbException {
        // 1. 创建请求令牌
        RequestTokenResponse tokenRes = executeSync(authenticationApi.createRequestToken());
        if (!tokenRes.isSuccess()) {
            throw new TmdbApiException("Failed to create request token");
        }
        // 2. 用户验证
        LoginRequest loginReq = new LoginRequest(username, password, tokenRes.getRequestToken());
        RequestTokenResponse validated = executeSync(authenticationApi.validateWithLogin(loginReq));
        if (!validated.isSuccess()) {
            throw new TmdbApiException("Invalid username or password");
        }
        // 3. 创建会话
        SessionResponse sessionRes = executeSync(authenticationApi.createSession(validated.getRequestToken()));
        if (!sessionRes.isSuccess()) {
            throw new TmdbApiException("Failed to create session");
        }
        String sessionId = sessionRes.getSessionId();
        // 4. 自动保存
        saveSession(sessionId);
        return sessionId;
    }

    /**
     * 创建游客会话，并自动保存到 SessionStore。
     *
     * @return guestSessionId
     */
    public String createGuestSession() throws TmdbException {
        GuestSessionResponse response = executeSync(authenticationApi.createGuestSession());
        if (!response.isSuccess()) {
            throw new TmdbApiException("Failed to create guest session");
        }
        String guestSessionId = response.getGuestSessionId();
        saveSession(guestSessionId);
        return guestSessionId;
    }

    /**
     * 手动保存 SessionId 到当前会话键（由 SessionKeyProvider 决定键）。
     *
     * @param sessionId 会话ID
     */
    public void saveSession(String sessionId) {
        String key = sessionKeyProvider.getSessionKey();
        if (StrUtil.isBlank(key)) {
            throw new TmdbSessionException("SessionKeyProvider returned blank");
        }
        sessionStore.save(key, sessionId);
    }

    /**
     * 删除当前会话（根据当前 SessionKeyProvider 的键删除本地存储）。
     */
    public void deleteSession() {
        String key = sessionKeyProvider.getSessionKey();
        if (StrUtil.isNotBlank(key)) {
            sessionStore.remove(key);
        }
    }

    /**
     * 获取当前会话 ID（基于当前 SessionKeyProvider 的键从 SessionStore 读取）。
     *
     * @return sessionId 或 null
     */
    public String getCurrentSessionId() {
        String key = sessionKeyProvider.getSessionKey();
        return StrUtil.isNotBlank(key) ? sessionStore.get(key) : null;
    }

    /**
     * 登出：清除本地会话，并可选地通知 TMDB 删除远程会话。
     */
    public void logout() throws TmdbException {
        String sessionId = getCurrentSessionId();
        if (StrUtil.isNotBlank(sessionId)) {
            try {
                executeSync(authenticationApi.deleteSession(sessionId));
            } catch (Exception e) {
                // 远程删除失败不影响本地清除，可记录日志
            }
        }
        deleteSession();
    }

    // ==================== API 封装 ====================
    // ==================== 认证相关接口 ====================



    public Movie getMovieDetails(int movieId) throws TmdbException {
        return executeSync(moviesApi.getDetails(movieId));
    }

    public Account getAccountDetails() throws TmdbException {
        return executeSync(accountApi.getAccountDetails());
    }

    // ==================== 内部同步执行器 ====================
    private <T> T executeSync(Call<T> call) throws TmdbException {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                String errorBody = response.errorBody() != null ? response.errorBody().string() : StrUtil.EMPTY;
                throw new TmdbHttpException("HTTP error: " + errorBody, response.code());
            }
        } catch (IOException e) {
            throw new TmdbIOException("Network error", e);
        }
    }

    // ==================== Builder ====================

    public static class Builder {

        private final String bearerToken;
        private String apiKey;
        // 默认使用 Bearer Token
        private AuthMethod authMethod;
        private String baseUrl = "https://api.themoviedb.org/3/";
        private long connectTimeout = 30;
        private long readTimeout = 30;
        private SessionStore sessionStore;
        private SessionKeyProvider sessionKeyProvider;
        private okhttp3.Interceptor loggingInterceptor;

        /**
         * 使用 Bearer Token 方式（推荐）
         *
         * @param bearerToken Bearer Token
         */
        public Builder(String bearerToken) {
            this.bearerToken = bearerToken;
            this.authMethod = AuthMethod.BEARER_TOKEN;
        }

        /**
         * 使用 API Key 方式（旧方式，不推荐）
         */
        public Builder withApiKey(String apiKey) {
            this.apiKey = apiKey;
            this.authMethod = AuthMethod.API_KEY_QUERY;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder connectTimeout(long seconds) {
            this.connectTimeout = seconds;
            return this;
        }

        public Builder readTimeout(long seconds) {
            this.readTimeout = seconds;
            return this;
        }

        public Builder sessionStore(SessionStore sessionStore) {
            this.sessionStore = sessionStore;
            return this;
        }

        public Builder sessionKeyProvider(SessionKeyProvider provider) {
            this.sessionKeyProvider = provider;
            return this;
        }

        public Builder loggingInterceptor(okhttp3.Interceptor interceptor) {
            this.loggingInterceptor = interceptor;
            return this;
        }

        public TmdbClient build() {
            // 验证认证信息
            if (authMethod == AuthMethod.BEARER_TOKEN && StrUtil.isBlank(bearerToken)) {
                throw new IllegalArgumentException("Bearer token is required when using BEARER_TOKEN auth");
            }
            if (authMethod == AuthMethod.API_KEY_QUERY && StrUtil.isBlank(apiKey)) {
                throw new IllegalArgumentException("API Key is required when using API_KEY_QUERY auth");
            }
            if (StrUtil.isBlank(baseUrl)) {
                throw new IllegalArgumentException("Base Url is required");
            }
            if (connectTimeout <= 0 || readTimeout <= 0) {
                throw new IllegalArgumentException("Connect Timeout or Read Timeout is required");
            }
            if (sessionStore == null) {
                throw new IllegalArgumentException("SessionStore must be provided");
            }
            if (sessionKeyProvider == null) {
                throw new IllegalArgumentException("SessionKeyProvider must be provided");
            }
            return new TmdbClient(this);
        }
    }
}
