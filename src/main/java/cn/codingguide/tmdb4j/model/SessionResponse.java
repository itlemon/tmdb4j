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
public class SessionResponse {

    private boolean success;
    @SerializedName("session_id")
    private String sessionId;
}
