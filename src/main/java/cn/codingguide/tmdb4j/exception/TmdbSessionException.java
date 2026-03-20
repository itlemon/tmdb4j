package cn.codingguide.tmdb4j.exception;

/**
 * 会话异常（可单独扩展）
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public class TmdbSessionException extends TmdbException {

    public TmdbSessionException(String message) {
        super(message);
    }

}
