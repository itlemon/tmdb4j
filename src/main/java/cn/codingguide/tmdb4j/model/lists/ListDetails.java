package cn.codingguide.tmdb4j.model.lists;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Details of a user-defined list, including metadata and paginated items.
 * <p>
 * 用户自定义列表的详情，包含元数据和分页项目列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class ListDetails {

    /**
     * The username of the creator of the list.
     * 列表创建者的用户名。
     */
    @SerializedName("created_by")
    private String createdBy;

    /**
     * The description of the list (may be null or empty).
     * 列表的描述（可能为 null 或空字符串）。
     */
    private String description;

    /**
     * The number of times this list has been favorited by users.
     * 该列表被用户收藏的次数。
     */
    @SerializedName("favorite_count")
    private int favoriteCount;

    /**
     * The unique identifier of the list.
     * 列表的唯一标识符。
     */
    private int id;

    /**
     * The ISO 639-1 language code of the list (e.g., "en-US").
     * 列表的 ISO 639-1 语言代码（例如 "en-US"）。
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * The number of items in the list.
     * 列表中的项目数量。
     */
    @SerializedName("item_count")
    private int itemCount;

    /**
     * The list of items (movies or TV series) in this list.
     * 列表中的项目（电影或电视剧）列表。
     */
    private List<ListItem> items;

    /**
     * The name of the list.
     * 列表的名称。
     */
    private String name;

    /**
     * Current page number (for paginated results).
     * 当前页码（分页结果）。
     */
    private int page;

    /**
     * The poster image path of the list (may be null).
     * 列表的海报图片路径（可能为 null）。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * Total number of pages.
     * 总页数。
     */
    @SerializedName("total_pages")
    private int totalPages;

    /**
     * Total number of results.
     * 总结果数。
     */
    @SerializedName("total_results")
    private int totalResults;

}
