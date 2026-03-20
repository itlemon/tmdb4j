package cn.codingguide.tmdb4j.session;

/**
 * 会话存储接口
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public interface SessionStore {

    /**
     * 保存会话ID
     *
     * @param key       会话键（由 SessionKeyProvider 生成）
     * @param sessionId TMDB session_id
     */
    void save(String key, String sessionId);

    /**
     * 获取会话ID
     *
     * @param key 会话键
     * @return sessionId 或 null
     */
    String get(String key);

    /**
     * 移除会话
     *
     * @param key 会话键
     */
    void remove(String key);

}
