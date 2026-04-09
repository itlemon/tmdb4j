package cn.codingguide.tmdb4j.model.movies;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a date range (minimum and maximum) for movie release dates.
 * <p>
 * 表示电影上映日期的范围（最小和最大日期）。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class DateRange {

    /**
     * The maximum release date (format: YYYY-MM-DD).
     * 最大上映日期（格式：YYYY-MM-DD）。
     */
    private String maximum;

    /**
     * The minimum release date (format: YYYY-MM-DD).
     * 最小上映日期（格式：YYYY-MM-DD）。
     */
    private String minimum;

}
