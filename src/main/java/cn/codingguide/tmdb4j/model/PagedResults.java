package cn.codingguide.tmdb4j.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class PagedResults<T> {

    /**
     * 当前页码
     */
    private int page;

    /**
     * 总结果数
     */
    @SerializedName("total_results")
    private int totalResults;

    /**
     * 总页数
     */
    @SerializedName("total_pages")
    private int totalPages;

    /**
     * 结果列表，元素类型由泛型 T 决定
     */
    private List<T> results;

}
