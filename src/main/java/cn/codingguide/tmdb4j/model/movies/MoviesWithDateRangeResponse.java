package cn.codingguide.tmdb4j.model.movies;

import cn.codingguide.tmdb4j.model.PagedResults;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response for the now-playing or up-coming movies endpoint.
 * Contains a date range and paginated list of movies.
 * <p>
 * 正在或即将上映电影端点的响应。
 * 包含日期范围和分页的电影列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString(callSuper = true)
public class MoviesWithDateRangeResponse extends PagedResults<Movie> {

    /**
     * The date range (minimum and maximum release dates) for the results.
     * 结果的日期范围（最小和最大上映日期）。
     */
    private DateRange dates;

}
