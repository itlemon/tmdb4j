package cn.codingguide.tmdb4j.auth;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public enum AuthMethod {

    /**
     * 将 API Key 作为 URL 查询参数（旧方式，不推荐）
     */
    API_KEY_QUERY,
    /**
     * 使用 Bearer Token 放在 Authorization 头中（推荐）
     */
    BEARER_TOKEN

}
