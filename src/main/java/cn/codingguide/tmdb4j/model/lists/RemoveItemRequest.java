package cn.codingguide.tmdb4j.model.lists;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Request body for removing an item from a user-defined list.
 * <p>
 * 从用户自定义列表中移除项目的请求体。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@Builder
@ToString
public class RemoveItemRequest {

    /**
     * The type of media to remove. Valid values: "movie" or "tv".
     * 要移除的媒体类型。有效值："movie" 或 "tv"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The ID of the movie or TV series to remove.
     * 要移除的电影或电视剧的 ID。
     */
    @SerializedName("media_id")
    private int mediaId;

}
