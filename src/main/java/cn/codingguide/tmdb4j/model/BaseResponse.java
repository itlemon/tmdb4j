package cn.codingguide.tmdb4j.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Getter
@Setter
@ToString
public class BaseResponse {

    /**
     * Indicates whether the operation was successful.
     * 表示操作是否成功。
     */
    @SerializedName("success")
    private boolean success;

    /**
     * The HTTP status code.
     * HTTP 状态码。
     */
    @SerializedName("status_code")
    private Integer statusCode;

    /**
     * The status message.
     * 状态消息。
     */
    @SerializedName("status_message")
    private String statusMessage;
}
