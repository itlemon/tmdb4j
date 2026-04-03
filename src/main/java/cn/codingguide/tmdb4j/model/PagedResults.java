package cn.codingguide.tmdb4j.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Generic paginated result wrapper for TMDB list responses.
 * <p>
 * TMDB 列表响应的通用分页结果包装类。
 * </p>
 *
 * @param <T> The type of items in the results list. / 结果列表中元素的类型。
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class PagedResults<T> {

    /**
     * Current page number.
     * 当前页码。
     */
    private int page;

    /**
     * Total number of results available.
     * 可用的总结果数。
     */
    @SerializedName("total_results")
    private int totalResults;

    /**
     * Total number of pages.
     * 总页数。
     */
    @SerializedName("total_pages")
    private int totalPages;

    /**
     * List of items for the current page.
     * 当前页的项目列表。
     */
    private List<T> results;

}
