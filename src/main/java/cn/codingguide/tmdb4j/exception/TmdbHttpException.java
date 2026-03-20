package cn.codingguide.tmdb4j.exception;

import lombok.Getter;

/**
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@Getter
public abstract class TmdbHttpException extends TmdbException {

    private final int httpStatusCode;

    protected TmdbHttpException(String message, int httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    protected TmdbHttpException(String message, int httpStatusCode, Throwable cause) {
        super(message, cause);
        this.httpStatusCode = httpStatusCode;
    }

}
