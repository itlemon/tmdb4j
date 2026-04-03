package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.genres.GenreListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface GenresApi {

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
    @GET("genre/movie/list")
    Call<GenreListResponse> getMovieGenres(@Query("language") String language);

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
    @GET("genre/tv/list")
    Call<GenreListResponse> getTvGenres(@Query("language") String language);
}
