package cn.codingguide.tmdb4j.exception;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class TmdbException extends RuntimeException {

    protected TmdbException(String message) {
        super(message);
    }

    protected TmdbException(String message, Throwable cause) {
        super(message, cause);
    }

}
