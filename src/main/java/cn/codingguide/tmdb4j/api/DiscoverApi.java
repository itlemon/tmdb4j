package cn.codingguide.tmdb4j.api;

import java.util.Map;

import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.movies.Movie;
import cn.codingguide.tmdb4j.model.tvs.TvSeries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface DiscoverApi {

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
    @GET("discover/movie")
    Call<PagedResults<Movie>> discoverMovies(@QueryMap Map<String, String> options);

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
    @GET("discover/tv")
    Call<PagedResults<TvSeries>> discoverTvs(@QueryMap Map<String, String> options);

}
