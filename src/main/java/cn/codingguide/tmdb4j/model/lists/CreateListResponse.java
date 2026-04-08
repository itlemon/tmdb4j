package cn.codingguide.tmdb4j.model.lists;

import cn.codingguide.tmdb4j.model.BaseResponse;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response for creating a new user-defined list.
 * <p>
 * 创建新用户自定义列表的响应。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@Getter
@Setter
@ToString(callSuper = true)
public class CreateListResponse extends BaseResponse {

    /**
     * The unique identifier of the newly created list.
     * 新创建的列表的唯一标识符。
     */
    @SerializedName("list_id")
    private int listId;

}
