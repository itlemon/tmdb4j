package cn.codingguide.tmdb4j.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {

    private String username;
    private String password;
    @SerializedName("request_token")
    private String requestToken;

}
