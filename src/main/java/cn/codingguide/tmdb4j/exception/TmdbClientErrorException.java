package cn.codingguide.tmdb4j.exception;

import lombok.Getter;

/**
 * 客户端错误（4xx） - 包含 TMDB 业务错误码
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@Getter
public class TmdbClientErrorException extends TmdbHttpException {

    private final int tmdbStatusCode;
    private final String tmdbStatusMessage;

    public TmdbClientErrorException(String message, int httpStatusCode, int tmdbStatusCode, String tmdbStatusMessage) {
        super(message, httpStatusCode);
        this.tmdbStatusCode = tmdbStatusCode;
        this.tmdbStatusMessage = tmdbStatusMessage;
    }

}
