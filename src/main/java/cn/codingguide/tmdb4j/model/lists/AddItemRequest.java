package cn.codingguide.tmdb4j.model.lists;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Request body for adding an item to a user-defined list.
 * <p>
 * 向用户自定义列表中添加项目的请求体。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@Getter
@Setter
@Builder
@ToString
public class AddItemRequest {

    /**
     * The type of media to add. Valid values: "movie" or "tv".
     * 要添加的媒体类型。有效值："movie" 或 "tv"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The ID of the movie or TV series to add.
     * 要添加的电影或电视剧的 ID。
     */
    @SerializedName("media_id")
    private int mediaId;

}
