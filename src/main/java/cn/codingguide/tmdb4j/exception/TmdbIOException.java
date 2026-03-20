package cn.codingguide.tmdb4j.exception;

/**
 * 网络/IO 异常
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public class TmdbIOException extends TmdbException {

    public TmdbIOException(String message) {
        super(message);
    }

    public TmdbIOException(String message, Throwable cause) {
        super(message, cause);
    }

}
