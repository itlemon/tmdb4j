package cn.codingguide.tmdb4j.model;

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

    private boolean success;
    private int statusCode;
    private String statusMessage;
}
