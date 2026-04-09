package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.movies.Movie;
import cn.codingguide.tmdb4j.model.movies.MovieDetails;
import cn.codingguide.tmdb4j.model.movies.MoviesWithDateRangeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public interface MoviesApi {

    /**
     * Get the list of movies currently playing in theaters.
     * Results are paginated and localized based on the provided language and region.
     * <p>
     * 获取当前正在影院上映的电影列表。
     * 结果基于提供的语言和地区进行分页和本地化。
     *
     * @param languageCode Optional ISO 639-1 language code (e.g., "en-US", "zh-CN", default "en-US").
     *                     可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN", 默认 "en-US"）。
     * @param page         Optional page number (default 1).
     *                     可选的页码（默认为 1）。
     * @param countryCode  Optional ISO 3166-1 country code for regional release dates.
     *                     可选的 ISO 3166-1 国家代码，用于区域性上映日期。
     * @return MoviesWithDateRangeResponse containing date range and movies.
     * 包含日期范围和电影的 MoviesWithDateRangeResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/movie-now-playing-list">API LINK</a>
     */
    @GET("movie/now_playing")
    Call<MoviesWithDateRangeResponse> getNowPlaying(
            @Query("language") String languageCode,
            @Query("page") Integer page,
            @Query("region") String countryCode
    );

    /**
     * Get the list of upcoming movies (releasing in the near future).
     * Results are paginated and localized based on the provided language and region.
     * <p>
     * 获取即将上映的电影列表（近期将上映）。
     * 结果基于提供的语言和地区进行分页和本地化。
     *
     * @param languageCode Optional ISO 639-1 language code (e.g., "en-US", "zh-CN", default "en-US").
     *                     可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN", 默认 "en-US"）。
     * @param page         Optional page number (default 1).
     *                     可选的页码（默认为 1）。
     * @param countryCode  Optional ISO 3166-1 country code for regional release dates.
     *                     可选的 ISO 3166-1 国家代码，用于区域性上映日期。
     * @return MoviesWithDateRangeResponse containing date range and movies.
     * 包含日期范围和电影的 MoviesWithDateRangeResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/movie-upcoming-list">API LINK</a>
     */
    @GET("movie/upcoming")
    Call<MoviesWithDateRangeResponse> getUpcoming(
            @Query("language") String languageCode,
            @Query("page") Integer page,
            @Query("region") String countryCode
    );

    /**
     * Get the list of popular movies.
     * Results are paginated and localized based on the provided language and region.
     * <p>
     * 获取热门电影列表。
     * 结果基于提供的语言和地区进行分页和本地化。
     *
     * @param languageCode Optional ISO 639-1 language code (e.g., "en-US", "zh-CN", default "en-US").
     *                     可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN", 默认 "en-US"）。
     * @param page         Optional page number (default 1).
     *                     可选的页码（默认为 1）。
     * @param countryCode  Optional ISO 3166-1 country code for regional release dates.
     *                     可选的 ISO 3166-1 国家代码，用于区域性上映日期。
     * @return Paginated results of popular movies.
     * 热门电影的分页结果。
     * @see <a href="https://developer.themoviedb.org/reference/movie-popular-list">API LINK</a>
     */
    @GET("movie/popular")
    Call<PagedResults<Movie>> getPopularMovies(
            @Query("language") String languageCode,
            @Query("page") Integer page,
            @Query("region") String countryCode
    );

    /**
     * Get the list of top-rated movies.
     * Results are paginated and localized based on the provided language and region.
     * <p>
     * 获取评分最高的电影列表。
     * 结果基于提供的语言和地区进行分页和本地化。
     *
     * @param languageCode Optional ISO 639-1 language code (e.g., "en-US", "zh-CN", default "en-US").
     *                     可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN", 默认 "en-US"）。
     * @param page         Optional page number (default 1).
     *                     可选的页码（默认为 1）。
     * @param countryCode  Optional ISO 3166-1 country code for regional release dates.
     *                     可选的 ISO 3166-1 国家代码，用于区域性上映日期。
     * @return Paginated results of top-rated movies.
     * 评分最高电影的分页结果。
     * @see <a href="https://developer.themoviedb.org/reference/movie-top-rated-list">API LINK</a>
     */
    @GET("movie/top_rated")
    Call<PagedResults<Movie>> getTopRatedMovies(
            @Query("language") String languageCode,
            @Query("page") Integer page,
            @Query("region") String countryCode
    );

    /**
     * Get the detailed information of a specific movie.
     * Use append_to_response to include additional data (e.g., "credits,images").
     * <p>
     * 获取特定电影的详细信息。
     * 使用 append_to_response 可以包含附加数据（例如 "credits,images"）。
     *
     * @param movieId          The unique identifier of the movie.
     *                         电影的唯一标识符。
     * @param appendToResponse Optional comma-separated list of extra data to append (e.g., "credits,images").
     *                         可选的附加数据列表，多个用逗号分隔（例如 "credits,images"）。
     * @param languageCode     Optional ISO 639-1 language code (e.g., "en-US", "zh-CN", default "en-US").
     *                         可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN", 默认 "en-US"）。
     * @return MovieDetails object containing full movie information.
     * 包含完整电影信息的 MovieDetails 对象。
     * @see <a href="https://developer.themoviedb.org/reference/movie-details">API LINK</a>
     */
    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetails(
            @Path("movie_id") int movieId,
            @Query("append_to_response") String appendToResponse,
            @Query("language") String languageCode
    );

    @GET("movie/popular")
    Call<PagedResults<Movie>> getPopular(@Query("page") int page);

}
