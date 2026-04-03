package cn.codingguide.tmdb4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.codingguide.tmdb4j.api.AccountApi;
import cn.codingguide.tmdb4j.api.AuthenticationApi;
import cn.codingguide.tmdb4j.api.CertificationApi;
import cn.codingguide.tmdb4j.api.ChangesApi;
import cn.codingguide.tmdb4j.api.CollectionsApi;
import cn.codingguide.tmdb4j.api.MoviesApi;
import cn.codingguide.tmdb4j.auth.AuthMethod;
import cn.codingguide.tmdb4j.constants.SortBy;
import cn.codingguide.tmdb4j.exception.TmdbApiException;
import cn.codingguide.tmdb4j.exception.TmdbClientErrorException;
import cn.codingguide.tmdb4j.exception.TmdbException;
import cn.codingguide.tmdb4j.exception.TmdbIOException;
import cn.codingguide.tmdb4j.exception.TmdbSessionException;
import cn.codingguide.tmdb4j.interceptor.ApiKeyInterceptor;
import cn.codingguide.tmdb4j.interceptor.SessionInterceptor;
import cn.codingguide.tmdb4j.interceptor.TmdbResponseInterceptor;
import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.model.CustomList;
import cn.codingguide.tmdb4j.model.FavoriteRequest;
import cn.codingguide.tmdb4j.model.GuestSessionResponse;
import cn.codingguide.tmdb4j.model.LoginRequest;
import cn.codingguide.tmdb4j.model.Movie;
import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.RatedMovie;
import cn.codingguide.tmdb4j.model.RatedTvEpisode;
import cn.codingguide.tmdb4j.model.RatedTvSeries;
import cn.codingguide.tmdb4j.model.RequestTokenResponse;
import cn.codingguide.tmdb4j.model.SessionResponse;
import cn.codingguide.tmdb4j.model.TvSeries;
import cn.codingguide.tmdb4j.model.WatchlistRequest;
import cn.codingguide.tmdb4j.model.account.Account;
import cn.codingguide.tmdb4j.model.certifications.CertificationResponse;
import cn.codingguide.tmdb4j.model.changes.ChangedMovie;
import cn.codingguide.tmdb4j.model.changes.ChangedPerson;
import cn.codingguide.tmdb4j.model.changes.ChangedTvSeries;
import cn.codingguide.tmdb4j.model.collections.CollectionDetails;
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

    private final AccountApi accountApi;
    private final AuthenticationApi authenticationApi;
    private final CertificationApi certificationApi;
    private final ChangesApi changesApi;
    private final CollectionsApi collectionsApi;

    private final MoviesApi moviesApi;

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
                .addInterceptor(new TmdbResponseInterceptor())
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
        this.accountApi = retrofit.create(AccountApi.class);
        this.authenticationApi = retrofit.create(AuthenticationApi.class);
        this.certificationApi = retrofit.create(CertificationApi.class);
        this.changesApi = retrofit.create(ChangesApi.class);
        this.collectionsApi = retrofit.create(CollectionsApi.class);

        this.moviesApi = retrofit.create(MoviesApi.class);
    }

    // ==================== 会话管理接口 ====================

    /**
     * 创建正式用户会话（三步认证），并自动保存到 SessionStore。
     *
     * @param username TMDB 用户名
     * @param password TMDB 密码
     * @return sessionId
     */
    public String loginAndSaveSession(String username, String password) throws TmdbException {
        // 1. 创建请求令牌
        RequestTokenResponse tokenRes = createRequestToken();
        if (!tokenRes.isSuccess()) {
            throw new TmdbApiException("Failed to create request token");
        }
        // 2. 用户验证
        RequestTokenResponse validated = validateWithLogin(username, password, tokenRes.getRequestToken());
        if (!validated.isSuccess()) {
            throw new TmdbApiException("Invalid username or password");
        }
        // 3. 创建会话
        SessionResponse sessionRes = createSession(validated.getRequestToken());
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
    public String createAndSaveGuestSession() throws TmdbException {
        GuestSessionResponse response = createGuestSession();
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
    public void logoutAndDeleteSession() throws TmdbException {
        String sessionId = getCurrentSessionId();
        if (StrUtil.isNotBlank(sessionId)) {
            try {
                deleteSession(sessionId);
            } catch (Exception e) {
                // 远程删除失败不影响本地清除，可记录日志
            }
        }
        deleteSession();
    }

    // ==================== API 封装 ====================
    // ==================== 认证相关接口 ====================
    public RequestTokenResponse createRequestToken() throws TmdbException {
        return executeSync(authenticationApi.createRequestToken());
    }

    public RequestTokenResponse validateWithLogin(String username, String password, String requestToken) throws TmdbException {
        return executeSync(authenticationApi.validateWithLogin(new LoginRequest(username, password, requestToken)));
    }

    public SessionResponse createSession(String requestToken) throws TmdbException {
        return executeSync(authenticationApi.createSession(requestToken));
    }

    public BaseResponse deleteSession(String sessionId) throws TmdbException {
        return executeSync(authenticationApi.deleteSession(sessionId));
    }

    public GuestSessionResponse createGuestSession() throws TmdbException {
        return executeSync(authenticationApi.createGuestSession());
    }

    public BaseResponse validateKey() throws TmdbException {
        return executeSync(authenticationApi.validateKey());
    }

    // ==================== 账户相关接口 ====================

    /**
     * Get the public details of an account on TMDB.
     *
     * @param accountId AccountID
     * @return The public details of an account on TMDB.
     * @throws TmdbException
     */
    public Account getAccountDetails(int accountId) throws TmdbException {
        return executeSync(accountApi.getAccountDetails(accountId));
    }

    public BaseResponse addFavorite(int accountId, FavoriteRequest request) throws TmdbException {
        return executeSync(accountApi.addFavorite(accountId, request));
    }

    public BaseResponse addToWatchlist(int accountId, WatchlistRequest request) throws TmdbException {
        return executeSync(accountApi.addToWatchlist(accountId, request));
    }

    public PagedResults<Movie> getFavoriteMovies(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getFavoriteMovies(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<TvSeries> getFavoriteTvs(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getFavoriteTvs(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<CustomList> getCustomLists(int accountId, int page) throws TmdbException {
        return executeSync(accountApi.getCustomLists(accountId, page));
    }

    public PagedResults<RatedMovie> getRatedMovies(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getRatedMovies(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<RatedTvSeries> getRatedTvSeries(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getRatedTvSeries(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<RatedTvEpisode> getRatedTvEpisodes(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getRatedTvEpisodes(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<Movie> getWatchlistMovies(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getWatchlistMovies(accountId, language, page, sortBy.getValue()));
    }

    public PagedResults<TvSeries> getWatchlistTvs(int accountId, String language, int page, SortBy sortBy) throws TmdbException {
        return executeSync(accountApi.getWatchlistTvs(accountId, language, page, sortBy.getValue()));
    }

    // ==================== 电影、电视分级相关接口 ====================
    public CertificationResponse getMovieCertifications() throws TmdbException {
        return executeSync(certificationApi.getMovieCertifications());
    }

    public CertificationResponse getTvCertifications() throws TmdbException {
        return executeSync(certificationApi.getTvCertifications());
    }

    // ==================== 电影、电视、人物信息变更列表相关接口 ====================

    /**
     * Get a list of movie IDs that have been changed within a specified time period.
     * The results are paginated.
     * <p>
     * 获取在指定时间段内发生变更的电影 ID 列表。结果以分页形式返回。
     *
     * @param page      The page number to fetch. Minimum 1. Default 1.
     *                  要获取的页码。最小值为 1。默认为 1。
     * @param startDate Filter changes starting from this date (format: YYYY-MM-DD).
     *                  筛选变更的起始日期（格式：YYYY-MM-DD）。
     * @param endDate   Filter changes up to this date (format: YYYY-MM-DD).
     *                  筛选变更的结束日期（格式：YYYY-MM-DD）。
     * @return A paginated result containing a list of ChangedMovie objects.
     * 包含 ChangedMovie 对象列表的分页结果。
     */
    public PagedResults<ChangedMovie> getMovieChanges(int page, String startDate, String endDate) throws TmdbException {
        return executeSync(changesApi.getMovieChanges(page, startDate, endDate));
    }

    /**
     * Get a list of person IDs that have been changed within a specified time period.
     * The results are paginated.
     * <p>
     * 获取在指定时间段内发生变更的人员 ID 列表。结果以分页形式返回。
     *
     * @param page      The page number to fetch. Minimum 1. Default 1.
     *                  要获取的页码。最小值为 1。默认为 1。
     * @param startDate Filter changes starting from this date (format: YYYY-MM-DD).
     *                  筛选变更的起始日期（格式：YYYY-MM-DD）。
     * @param endDate   Filter changes up to this date (format: YYYY-MM-DD).
     *                  筛选变更的结束日期（格式：YYYY-MM-DD）。
     * @return A paginated result containing a list of ChangedPerson objects.
     * 包含 ChangedPerson 对象列表的分页结果。
     */
    public PagedResults<ChangedPerson> getPersonChanges(int page, String startDate, String endDate) throws TmdbException {
        return executeSync(changesApi.getPersonChanges(page, startDate, endDate));
    }

    /**
     * Get a list of TV series IDs that have been changed within a specified time period.
     * The results are paginated.
     * <p>
     * 获取在指定时间段内发生变更的电视剧 ID 列表。结果以分页形式返回。
     *
     * @param page      The page number to fetch. Minimum 1. Default 1.
     *                  要获取的页码。最小值为 1。默认为 1。
     * @param startDate Filter changes starting from this date (format: YYYY-MM-DD).
     *                  筛选变更的起始日期（格式：YYYY-MM-DD）。
     * @param endDate   Filter changes up to this date (format: YYYY-MM-DD).
     *                  筛选变更的结束日期（格式：YYYY-MM-DD）。
     * @return A paginated result containing a list of ChangedTvSeries objects.
     * 包含 ChangedTvSeries 对象列表的分页结果。
     */
    public PagedResults<ChangedTvSeries> getTvChanges(int page, String startDate, String endDate) throws TmdbException {
        return executeSync(changesApi.getTvChanges(page, startDate, endDate));
    }

    // ==================== 电影、电视合集相关接口 ====================

    /**
     * Get details of a movie collection (e.g., "Star Wars Collection").
     * The response includes collection information and the list of movies/TV shows in the collection.
     * <p>
     * 获取电影合集的详细信息（例如“星球大战合集”）。
     * 响应包含合集信息以及合集内的电影/电视剧列表。
     *
     * @param collectionId The unique identifier of the collection.
     *                     合集的唯一标识符。
     * @param language     The language to localize the results (ISO 639-1, optionally with region, e.g., "zh-CN").
     *                     结果本地化的语言（ISO 639-1，可选带地区，如 "zh-CN"）。
     * @return Collection details containing metadata and a list of parts.
     * 包含元数据和媒体项列表的合集详情。
     */
    public CollectionDetails getCollectionDetails(int collectionId, String language) throws TmdbException {
        return executeSync(collectionsApi.getCollectionDetails(collectionId, language));
    }

    public Movie getMovieDetails(int movieId) throws TmdbException {
        return executeSync(moviesApi.getDetails(movieId));
    }


    // ==================== 内部同步执行器 ====================
    private <T> T executeSync(Call<T> call) throws TmdbException {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                // 这里实际上已经被拦截器处理了，不会走到这
                throw new TmdbClientErrorException("Unexpected error", response.code(), 0, StrUtil.EMPTY);
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
