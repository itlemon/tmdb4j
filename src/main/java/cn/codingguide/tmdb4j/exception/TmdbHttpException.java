package cn.codingguide.tmdb4j.exception;

import lombok.Getter;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Getter
public class TmdbHttpException extends TmdbException {

    private final int httpStatusCode;

    public TmdbHttpException(String message, int httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public TmdbHttpException(String message, int httpStatusCode, Throwable cause) {
        super(message, cause);
        this.httpStatusCode = httpStatusCode;
    }

}
