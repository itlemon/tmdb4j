package cn.codingguide.tmdb4j;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

import cn.codingguide.tmdb4j.api.AccountApi;
import cn.codingguide.tmdb4j.api.AuthenticationApi;
import cn.codingguide.tmdb4j.api.MoviesApi;
import cn.codingguide.tmdb4j.auth.AuthMethod;
import cn.codingguide.tmdb4j.interceptor.ApiKeyInterceptor;
import cn.codingguide.tmdb4j.interceptor.SessionInterceptor;
import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.session.SessionKeyProvider;
import cn.codingguide.tmdb4j.session.SessionStore;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import okhttp3.OkHttpClient;
import retrofit2.Call;
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

    // 对外暴露 API 接口
    public MoviesApi movies() {
        return moviesApi;
    }

    public AccountApi account() {
        return accountApi;
    }

    public AuthenticationApi auth() {
        return authenticationApi;
    }

    /**
     * 在登录成功后，存储会话ID
     *
     * @param sessionId TMDB 返回的 session_id
     */
    public void saveSession(String sessionId) {
        String key = sessionKeyProvider.getSessionKey();
        if (StrUtil.isNotBlank(key)) {
            sessionStore.save(key, sessionId);
        }
    }

    /**
     * 登出：清除会话存储，并通知 TMDB 销毁会话
     */
    public void logout() {
        String key = sessionKeyProvider.getSessionKey();
        if (StrUtil.isNotBlank(key)) {
            String sessionId = sessionStore.get(key);
            if (StrUtil.isNotBlank(sessionId)) {
                // 异步删除远程会话（可选）
                authenticationApi.deleteSession(sessionId).enqueue(new retrofit2.Callback<BaseResponse>() {
                    @Override
                    public void onResponse(@Nonnull Call<BaseResponse> call,
                                           @Nonnull retrofit2.Response<BaseResponse> response) {
                        // 忽略结果，本地清除即可
                    }

                    @Override
                    public void onFailure(@Nonnull Call<BaseResponse> call, @Nonnull Throwable t) {
                        // 忽略网络错误
                    }
                });
            }
            sessionStore.remove(key);
        }
    }

    public static class Builder {

        private final String apiKey;
        private String bearerToken;
        // 默认使用 Bearer Token
        private AuthMethod authMethod;
        private String baseUrl = "https://api.themoviedb.org/3/";
        private long connectTimeout = 30;
        private long readTimeout = 30;
        private SessionStore sessionStore;
        private SessionKeyProvider sessionKeyProvider;
        private okhttp3.Interceptor loggingInterceptor;

        /**
         * 使用 API Key 方式（旧方式，不推荐）
         */
        public Builder(String apiKey) {
            this.apiKey = apiKey;
            this.authMethod = AuthMethod.API_KEY_QUERY;
        }

        /**
         * 使用 Bearer Token 方式（推荐）
         */
        public Builder withBearerToken(String bearerToken) {
            this.bearerToken = bearerToken;
            this.authMethod = AuthMethod.BEARER_TOKEN;
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
