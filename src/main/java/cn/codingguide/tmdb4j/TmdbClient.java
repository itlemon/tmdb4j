package cn.codingguide.tmdb4j;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.codingguide.tmdb4j.api.AccountApi;
import cn.codingguide.tmdb4j.api.AuthenticationApi;
import cn.codingguide.tmdb4j.api.CertificationApi;
import cn.codingguide.tmdb4j.api.ChangesApi;
import cn.codingguide.tmdb4j.api.CollectionsApi;
import cn.codingguide.tmdb4j.api.CompaniesApi;
import cn.codingguide.tmdb4j.api.ConfigurationApi;
import cn.codingguide.tmdb4j.api.CreditsApi;
import cn.codingguide.tmdb4j.api.DiscoverApi;
import cn.codingguide.tmdb4j.api.FindApi;
import cn.codingguide.tmdb4j.api.GenresApi;
import cn.codingguide.tmdb4j.api.GuestSessionApi;
import cn.codingguide.tmdb4j.api.MoviesApi;
import cn.codingguide.tmdb4j.auth.AuthMethod;
import cn.codingguide.tmdb4j.constants.ExternalSource;
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
import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.RequestTokenResponse;
import cn.codingguide.tmdb4j.model.SessionResponse;
import cn.codingguide.tmdb4j.model.WatchlistRequest;
import cn.codingguide.tmdb4j.model.account.AccountDetails;
import cn.codingguide.tmdb4j.model.certifications.CertificationResponse;
import cn.codingguide.tmdb4j.model.changes.ChangedMovie;
import cn.codingguide.tmdb4j.model.changes.ChangedPerson;
import cn.codingguide.tmdb4j.model.changes.ChangedTvSeries;
import cn.codingguide.tmdb4j.model.collections.CollectionDetails;
import cn.codingguide.tmdb4j.model.collections.CollectionImagesResponse;
import cn.codingguide.tmdb4j.model.collections.CollectionTranslationsResponse;
import cn.codingguide.tmdb4j.model.companies.CompanyAlternativeNamesResponse;
import cn.codingguide.tmdb4j.model.companies.CompanyDetails;
import cn.codingguide.tmdb4j.model.companies.CompanyImagesResponse;
import cn.codingguide.tmdb4j.model.configuration.ConfigurationResponse;
import cn.codingguide.tmdb4j.model.configuration.CountryInfo;
import cn.codingguide.tmdb4j.model.configuration.JobDepartment;
import cn.codingguide.tmdb4j.model.configuration.LanguageInfo;
import cn.codingguide.tmdb4j.model.configuration.TimezoneEntry;
import cn.codingguide.tmdb4j.model.credits.CreditResponse;
import cn.codingguide.tmdb4j.model.discover.MovieDiscoverOptions;
import cn.codingguide.tmdb4j.model.discover.TvDiscoverOptions;
import cn.codingguide.tmdb4j.model.find.FindResponse;
import cn.codingguide.tmdb4j.model.genres.GenreListResponse;
import cn.codingguide.tmdb4j.model.movies.Movie;
import cn.codingguide.tmdb4j.model.movies.RatedMovie;
import cn.codingguide.tmdb4j.model.tvs.RatedTvEpisode;
import cn.codingguide.tmdb4j.model.tvs.RatedTvSeries;
import cn.codingguide.tmdb4j.model.tvs.TvSeries;
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
    private final CompaniesApi companiesApi;
    private final ConfigurationApi configurationApi;
    private final CreditsApi creditsApi;
    private final DiscoverApi discoverApi;
    private final FindApi findApi;
    private final GenresApi genresApi;
    private final GuestSessionApi guestSessionApi;

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
        this.companiesApi = retrofit.create(CompaniesApi.class);
        this.configurationApi = retrofit.create(ConfigurationApi.class);
        this.creditsApi = retrofit.create(CreditsApi.class);
        this.discoverApi = retrofit.create(DiscoverApi.class);
        this.findApi = retrofit.create(FindApi.class);
        this.genresApi = retrofit.create(GenresApi.class);
        this.guestSessionApi = retrofit.create(GuestSessionApi.class);

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
    public AccountDetails getAccountDetails(int accountId) throws TmdbException {
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
     * @see <a href="https://developer.themoviedb.org/reference/changes-movie-list">API LINK</a>
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
     * @see <a href="https://developer.themoviedb.org/reference/changes-people-list">API LINK</a>
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
     * @see <a href="https://developer.themoviedb.org/reference/changes-tv-list">API LINK</a>
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
     * @see <a href="https://developer.themoviedb.org/reference/collection-details">API LINK</a>
     */
    public CollectionDetails getCollectionDetails(int collectionId, String language) throws TmdbException {
        return executeSync(collectionsApi.getCollectionDetails(collectionId, language));
    }

    /**
     * Get images (backdrops and posters) for a specific collection.
     * The response includes two lists: backdrops and posters, each containing image metadata.
     * <p>
     * 获取指定合集的图片（背景图和海报）。
     * 响应包含两个列表：背景图和海报，每个列表包含图片的元数据。
     *
     * @param collectionId         The unique identifier of the collection.
     *                             合集的唯一标识符。
     * @param language             Optional language filter (ISO 639-1 code) to limit images to a specific language.
     *                             可选的语言过滤器（ISO 639-1 代码），将图片限制为特定语言。
     * @param includeImageLanguage specify a comma separated list of ISO-639-1 values to query, for example: en-US,null
     *                             额外的图片语言列表，多个用逗号分隔
     * @return CollectionImagesResponse containing backdrops and posters.
     * 包含背景图和海报的合集图片响应。
     * @see <a href="https://developer.themoviedb.org/reference/collection-images">API LINK</a>
     */
    public CollectionImagesResponse getCollectionImages(int collectionId, String language,
                                                        String includeImageLanguage) throws TmdbException {
        return executeSync(collectionsApi.getCollectionImages(collectionId, language, includeImageLanguage));
    }

    /**
     * Get a list of translations for a specific collection.
     * Each translation contains language metadata and the translated title, overview, and homepage.
     * <p>
     * 获取指定合集的翻译列表。
     * 每个翻译包含语言元数据以及翻译后的标题、概述和主页。
     *
     * @param collectionId The unique identifier of the collection.
     *                     合集的唯一标识符。
     * @return CollectionTranslationsResponse containing the list of translations.
     * 包含翻译列表的合集翻译响应。
     * @see <a href="https://developer.themoviedb.org/reference/collection-translations">API LINK</a>
     */
    public CollectionTranslationsResponse getCollectionTranslations(int collectionId) throws TmdbException {
        return executeSync(collectionsApi.getCollectionTranslations(collectionId));
    }

    // ==================== 电影公司相关接口 ====================

    /**
     * Get details of a production company by its ID.
     * The response includes company information such as name, description, headquarters, homepage, logo, and parent
     * company.
     * <p>
     * 根据公司 ID 获取制作公司的详细信息。
     * 响应包含公司信息，如名称、描述、总部、主页、标志以及母公司。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyDetails object containing the company information.
     * 包含公司信息的 CompanyDetails 对象。
     * @see <a href="https://developer.themoviedb.org/reference/company-details">API LINK</a>
     */
    public CompanyDetails getCompanyDetails(int companyId) throws TmdbException {
        return executeSync(companiesApi.getCompanyDetails(companyId));
    }

    /**
     * Get a list of alternative names for a specific company.
     * The response includes the company ID and a list of alternative names with language and country codes.
     * <p>
     * 获取指定公司的备选名称列表。
     * 响应包含公司 ID 以及带有语言和国家代码的备选名称列表。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyAlternativeNamesResponse containing the list of alternative names.
     * 包含备选名称列表的公司备选名称响应。
     * @see <a href="https://developer.themoviedb.org/reference/company-alternative-names">API LINK</a>
     */
    public CompanyAlternativeNamesResponse getCompanyAlternativeNames(int companyId) throws TmdbException {
        return executeSync(companiesApi.getCompanyAlternativeNames(companyId));
    }

    /**
     * Get logo images for a specific company.
     * The response includes a list of logo images with metadata such as dimensions, language, and vote statistics.
     * <p>
     * 获取指定公司的标志图片。
     * 响应包含标志图片列表及其元数据（尺寸、语言、投票统计等）。
     *
     * @param companyId The unique identifier of the company.
     *                  公司的唯一标识符。
     * @return CompanyImagesResponse containing the list of logo images.
     * 包含标志图片列表的公司图片响应。
     * @see <a href="https://developer.themoviedb.org/reference/company-images">API LINK</a>
     */
    public CompanyImagesResponse getCompanyImages(int companyId) throws TmdbException {
        return executeSync(companiesApi.getCompanyImages(companyId));
    }

    // ==================== API 配置相关接口 ====================

    /**
     * Get the API configuration information.
     * This includes image base URLs, available size options, and change keys.
     * <p>
     * 获取 API 配置信息。
     * 包括图片基础 URL、可用尺寸选项以及变更密钥。
     *
     * @return ConfigurationResponse containing global configuration data.
     * 包含全局配置数据的 ConfigurationResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-details">API LINK</a>
     */
    public ConfigurationResponse getConfigurationDetails() throws TmdbException {
        return executeSync(configurationApi.getConfigurationDetails());
    }

    /**
     * Get the list of countries supported by TMDB.
     * The response is an array of country objects containing ISO 3166-1 codes, English names, and native names.
     * <p>
     * 获取 TMDB 支持的国家/地区列表。
     * 响应是一个国家对象数组，包含 ISO 3166-1 代码、英文名称和本土名称。
     *
     * @return A list of CountryInfo objects.
     * CountryInfo 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-countries">API LINK</a>
     */
    public List<CountryInfo> getCountries() throws TmdbException {
        return executeSync(configurationApi.getCountries());
    }

    /**
     * Get the list of languages supported by TMDB.
     * The response is an array of language objects containing ISO 639-1 codes, English names, and native names.
     * <p>
     * 获取 TMDB 支持的语言列表。
     * 响应是一个语言对象数组，包含 ISO 639-1 代码、英文名称和本土名称。
     *
     * @return A list of LanguageInfo objects.
     * LanguageInfo 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-languages">API LINK</a>
     */
    public List<LanguageInfo> getLanguages() throws TmdbException {
        return executeSync(configurationApi.getLanguages());
    }

    /**
     * Get the list of departments and their associated jobs.
     * The response is an array of JobDepartment objects.
     * <p>
     * 获取部门及其关联的工作岗位列表。
     * 响应是一个 JobDepartment 对象数组。
     *
     * @return A list of JobDepartment objects.
     * JobDepartment 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-jobs">API LINK</a>
     */
    public List<JobDepartment> getJobs() throws TmdbException {
        return executeSync(configurationApi.getJobs());
    }

    /**
     * Get the list of primary translation language codes supported by TMDB.
     * The response is an array of language codes with optional region suffix (e.g., "en-US", "zh-CN").
     * <p>
     * 获取 TMDB 支持的主要翻译语言代码列表。
     * 响应是一个语言代码数组，可能包含地区后缀（例如 "en-US", "zh-CN"）。
     *
     * @return A list of language code strings (e.g., "af-ZA", "ar-AE").
     * 语言代码字符串列表（例如 "af-ZA", "ar-AE"）。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-primary-translations">API LINK</a>
     */
    public List<String> getPrimaryTranslations() throws TmdbException {
        return executeSync(configurationApi.getPrimaryTranslations());
    }

    /**
     * Get the list of time zones supported by TMDB.
     * The response is an array of TimezoneEntry objects, each containing a country code and its time zones.
     * <p>
     * 获取 TMDB 支持的时区列表。
     * 响应是一个 TimezoneEntry 对象数组，每个对象包含国家代码及其时区列表。
     *
     * @return A list of TimezoneEntry objects.
     * TimezoneEntry 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-timezones">API LINK</a>
     */
    public List<TimezoneEntry> getTimezones() throws TmdbException {
        return executeSync(configurationApi.getTimezones());
    }

    // ==================== 演职员等相关接口 ====================

    /**
     * Get details of a credit (cast/crew) by its ID.
     * The response includes information about the credit type, media, and person.
     * <p>
     * 根据演职员记录 ID 获取详情。
     * 响应包含演职员类型、关联媒体和人员的信息。
     *
     * @param creditId The unique identifier of the credit.
     *                 演职员记录的唯一标识符。
     * @return CreditResponse containing the credit details.
     * 包含演职员详情的 CreditResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/credit-details">API LINK</a>
     */
    public CreditResponse getCreditDetails(String creditId, String language) throws TmdbException {
        return executeSync(creditsApi.getCreditDetails(creditId, language));
    }

    // ==================== 高级筛选电影电视相关接口 ====================

    /**
     * Discover movies by various filters.
     * Returns a paginated list of movies matching the criteria.
     * <p>
     * 通过多种筛选条件发现电影。
     * 返回符合条件的分页电影列表。
     *
     * @param options The discover options (filters, sorting, pagination).
     *                发现选项（过滤器、排序、分页）。
     * @return A paginated result of Movie objects.
     * 电影对象的分页结果。
     * @see <a href="https://developer.themoviedb.org/reference/discover-movie">API LINK</a>
     */
    public PagedResults<Movie> discoverMovies(MovieDiscoverOptions options) throws TmdbException {
        return executeSync(discoverApi.discoverMovies(options.toQueryMap()));
    }

    /**
     * Discover TV series by various filters.
     * Returns a paginated list of TV series matching the criteria.
     * <p>
     * 通过多种筛选条件发现电视剧。
     * 返回符合条件的电视剧分页列表。
     *
     * @param options The discover options as a map (filters, sorting, pagination).
     *                发现选项作为映射（过滤器、排序、分页）。
     * @return A paginated result of TvSeries objects.
     * 电视剧对象的分页结果。
     * @see <a href="https://developer.themoviedb.org/reference/discover-tv">API LINK</a>
     */
    public PagedResults<TvSeries> discoverTvs(TvDiscoverOptions options) throws TmdbException {
        return executeSync(discoverApi.discoverTvs(options.toQueryMap()));
    }

    // ==================== 外部ID查询数据相关接口 ====================

    /**
     * Find TMDB items by an external ID.
     * <p>
     * 通过外部 ID 查找 TMDB 条目。
     *
     * @param externalId     The external ID to look up.
     *                       要查找的外部 ID。
     * @param externalSource The source of the external ID (use ExternalSource enum).
     *                       外部 ID 的来源（使用 ExternalSource 枚举）。
     * @param language       Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                       可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @return FindResponse containing lists of matching items.
     * 包含匹配项列表的 FindResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/find-by-id">API LINK</a>
     */
    public FindResponse findByExternalId(String externalId, ExternalSource externalSource, String language) throws TmdbException {
        return executeSync(findApi.findByExternalId(externalId, externalSource.getValue(), language));
    }

    // ==================== 电影电视类型相关接口 ====================

    /**
     * Get the list of official genres for movies.
     * The results can be localized by providing a language parameter.
     * <p>
     * 获取电影的官方类型列表。
     * 可以通过提供 language 参数进行本地化。
     *
     * @param language Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                 可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @return A GenreListResponse containing the list of movie genres.
     * 包含电影类型列表的 GenreListResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/genre-movie-list">API LINK</a>
     */
    public GenreListResponse getMovieGenres(String language) throws TmdbException {
        return executeSync(genresApi.getMovieGenres(language));
    }

    /**
     * Get the list of official genres for TV series.
     * The results can be localized by providing a language parameter.
     * <p>
     * 获取电视剧的官方类型列表。
     * 可以通过提供 language 参数进行本地化。
     *
     * @param language Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                 可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @return A GenreListResponse containing the list of TV genres.
     * 包含电视剧类型列表的 GenreListResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/genre-tv-list">API LINK</a>
     */
    public GenreListResponse getTvGenres(String language) throws TmdbException {
        return executeSync(genresApi.getTvGenres(language));
    }

    // ==================== Guest Session 相关接口 ====================

    /**
     * Get the list of movies rated by a guest session.
     * The response is paginated and contains movie details with the user's rating.
     * <p>
     * 获取游客会话已评分的电影列表。
     * 响应为分页格式，包含电影详情及用户的评分。
     *
     * @param guestSessionId The guest session ID.
     *                       游客会话 ID。
     * @param language       Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                       可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param page           The page number (default 1).
     *                       页码（默认为 1）。
     * @param sortBy         Sort order (e.g., "created_at.asc", "created_at.desc").
     *                       排序方式（例如 "created_at.asc", "created_at.desc"）。
     * @return Paginated results of RatedMovie.
     * 分页的 RatedMovie 结果。
     * @see <a href="https://developer.themoviedb.org/reference/guest-session-rated-movies">API LINK</a>
     */
    public PagedResults<RatedMovie> getGuestSessionRatedMovies(String guestSessionId, String language, Integer page,
                                                               SortBy sortBy) throws TmdbException {
        return executeSync(guestSessionApi.getGuestSessionRatedMovies(guestSessionId, language, page,
                sortBy.getValue()));
    }

    /**
     * Get the list of TV series rated by a guest session.
     * The response is paginated and contains TV series details with the user's rating.
     * <p>
     * 获取游客会话已评分的电视剧列表。
     * 响应为分页格式，包含电视剧详情及用户的评分。
     *
     * @param guestSessionId The guest session ID.
     *                       游客会话 ID。
     * @param language       Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                       可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param page           The page number (default 1).
     *                       页码（默认为 1）。
     * @param sortBy         Sort order (e.g., "created_at.asc", "created_at.desc").
     *                       排序方式（例如 "created_at.asc", "created_at.desc"）。
     * @return Paginated results of RatedTvSeries.
     * 分页的 RatedTvSeries 结果。
     * @see <a href="https://developer.themoviedb.org/reference/guest-session-rated-tv">API LINK</a>
     */
    public PagedResults<RatedTvSeries> getGuestSessionRatedTv(String guestSessionId, String language, Integer page,
                                                              SortBy sortBy) throws TmdbException {
        return executeSync(guestSessionApi.getGuestSessionRatedTv(guestSessionId, language, page,
                sortBy.getValue()));
    }

    /**
     * Get the list of TV episodes rated by a guest session.
     * The response is paginated and contains episode details with the user's rating.
     * <p>
     * 获取游客会话已评分的剧集列表。
     * 响应为分页格式，包含剧集详情及用户的评分。
     *
     * @param guestSessionId The guest session ID.
     *                       游客会话 ID。
     * @param language       Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                       可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param page           The page number (default 1).
     *                       页码（默认为 1）。
     * @param sortBy         Sort order (e.g., "created_at.asc", "created_at.desc").
     *                       排序方式（例如 "created_at.asc", "created_at.desc"）。
     * @return Paginated results of RatedTvEpisode.
     * 分页的 RatedTvEpisode 结果。
     * @see <a href="https://developer.themoviedb.org/reference/guest-session-rated-tv-episodes">API LINK</a>
     */
    public PagedResults<RatedTvEpisode> getGuestSessionRatedTvEpisodes(String guestSessionId, String language,
                                                                       Integer page, SortBy sortBy) throws TmdbException {
        return executeSync(guestSessionApi.getGuestSessionRatedTvEpisodes(guestSessionId, language, page,
                sortBy.getValue()));
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
