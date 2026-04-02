package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.ChangedMovie;
import cn.codingguide.tmdb4j.model.PagedResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
public interface ChangesApi {

    /**
     * You can query this method up to 14 days at a time. Use the start_date and end_date query parameters. 100 items
     * are returned per page.
     *
     * @param page      页码，最小值为 1。
     * @param startDate 筛选变更的起始日期，格式为 YYYY-MM-DD。
     * @param endDate   筛选变更的结束日期，格式为 YYYY-MM-DD。
     */
    @GET("movie/changes")
    Call<PagedResults<ChangedMovie>> getMovieChanges(
            @Query("page") int page,
            @Query("start_date") String startDate,
            @Query("end_date") String endDate
    );
}
