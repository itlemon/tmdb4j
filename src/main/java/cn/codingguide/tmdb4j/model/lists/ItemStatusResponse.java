package cn.codingguide.tmdb4j.model.lists;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response for checking if an item exists in a user-defined list.
 * <p>
 * 检查用户自定义列表中是否存在某个项目的响应。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@Getter
@Setter
@ToString
public class ItemStatusResponse {

    /**
     * The ID of the list being queried.
     * 被查询的列表 ID。
     */
    private int id;

    /**
     * Indicates whether the item is present in the list.
     * 表示该项目是否在列表中。
     */
    @SerializedName("item_present")
    private boolean itemPresent;

}
