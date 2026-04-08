package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.keywords.Keyword;
import cn.codingguide.tmdb4j.model.movies.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
public interface KeywordsApi {

    /**
     * Get the basic information for a specific keyword ID.
     * <p>
     * 根据特定关键词ID获取其基本信息。
     *
     * @param keywordId The unique identifier of the keyword.
     *                  关键词的唯一标识符。
     * @return A Call object with a Keyword instance.
     * 一个包含Keyword实例的Call对象。
     * @see <a href="https://developer.themoviedb.org/reference/keyword-details">API LINK</a>
     */
    @GET("keyword/{keyword_id}")
    Call<Keyword> getKeywordDetails(@Path("keyword_id") int keywordId);

    /**
     * Get the list of movies that have this keyword.
     * The response is paginated and contains movie details.
     * This method is deprecated, Use /discover/movie with with_keywords instead.
     * <p>
     * 获取包含该关键词的电影列表。
     * 响应为分页格式，包含电影详情。
     * 这个接口过期了，请使用 /discover/movie 接口。
     *
     * @param keywordId The unique identifier of the keyword.
     *                  关键词的唯一标识符。
     * @param language  Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                  可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param page      The page number (default 1).
     *                  页码（默认为 1）。
     * @return Paginated results of movies.
     * 分页的电影结果。
     * @see <a href="https://developer.themoviedb.org/reference/keyword-movies">API LINK</a>
     */
    @Deprecated
    @GET("keyword/{keyword_id}/movies")
    Call<PagedResults<Movie>> getKeywordMovies(
            @Path("keyword_id") int keywordId,
            @Query("language") String language,
            @Query("page") int page
    );
}
