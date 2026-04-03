package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.changes.ChangedMovie;
import cn.codingguide.tmdb4j.model.changes.ChangedPerson;
import cn.codingguide.tmdb4j.model.changes.ChangedTvSeries;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
public interface ChangesApi {

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
    @GET("movie/changes")
    Call<PagedResults<ChangedMovie>> getMovieChanges(
            @Query("page") int page,
            @Query("start_date") String startDate,
            @Query("end_date") String endDate
    );

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
    @GET("person/changes")
    Call<PagedResults<ChangedPerson>> getPersonChanges(
            @Query("page") int page,
            @Query("start_date") String startDate,
            @Query("end_date") String endDate
    );

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
    @GET("tv/changes")
    Call<PagedResults<ChangedTvSeries>> getTvChanges(
            @Query("page") int page,
            @Query("start_date") String startDate,
            @Query("end_date") String endDate
    );


}
