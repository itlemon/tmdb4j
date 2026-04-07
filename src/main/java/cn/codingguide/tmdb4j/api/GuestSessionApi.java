package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.movies.RatedMovie;
import cn.codingguide.tmdb4j.model.tvs.RatedTvEpisode;
import cn.codingguide.tmdb4j.model.tvs.RatedTvSeries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
public interface GuestSessionApi {

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
    @GET("guest_session/{guest_session_id}/rated/movies")
    Call<PagedResults<RatedMovie>> getGuestSessionRatedMovies(
            @Path("guest_session_id") String guestSessionId,
            @Query("language") String language,
            @Query("page") Integer page,
            @Query("sort_by") String sortBy
    );

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
    @GET("guest_session/{guest_session_id}/rated/tv")
    Call<PagedResults<RatedTvSeries>> getGuestSessionRatedTv(
            @Path("guest_session_id") String guestSessionId,
            @Query("language") String language,
            @Query("page") Integer page,
            @Query("sort_by") String sortBy
    );

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
    @GET("guest_session/{guest_session_id}/rated/tv/episodes")
    Call<PagedResults<RatedTvEpisode>> getGuestSessionRatedTvEpisodes(
            @Path("guest_session_id") String guestSessionId,
            @Query("language") String language,
            @Query("page") Integer page,
            @Query("sort_by") String sortBy
    );

}
