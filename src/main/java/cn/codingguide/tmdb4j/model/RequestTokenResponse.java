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
public class RequestTokenResponse {

    private boolean success;
    @SerializedName("request_token")
    private String requestToken;
    @SerializedName("expires_at")
    private String expiresAt;
}
