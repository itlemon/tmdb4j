package cn.codingguide.tmdb4j.exception;

/**
 * 服务端错误（5xx）
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class TmdbServerErrorException extends TmdbHttpException {

    public TmdbServerErrorException(String message, int httpStatusCode) {
        super(message, httpStatusCode);
    }

}
