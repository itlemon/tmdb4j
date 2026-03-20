package cn.codingguide.tmdb4j.session;

/**
 * 会话键生成接口
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public interface SessionKeyProvider {

    /**
     * 返回当前上下文的会话键（例如 userId，或 userId+deviceId）
     * 调用时机：在拦截器中需要获取 session_id 时
     */
    String getSessionKey();

}
