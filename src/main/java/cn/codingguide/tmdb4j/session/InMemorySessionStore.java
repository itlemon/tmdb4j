package cn.codingguide.tmdb4j.session;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存存储实现，适用于单机环境或测试。
 * 注意：多实例集群下不共享，需使用 Redis 等外部存储。
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class InMemorySessionStore implements SessionStore {

    private final ConcurrentHashMap<String, String> store = new ConcurrentHashMap<>();

    @Override
    public void save(String sessionKey, String sessionId) {
        store.put(sessionKey, sessionId);
    }

    @Override
    public String get(String sessionKey) {
        return store.get(sessionKey);
    }

    @Override
    public void remove(String sessionKey) {
        store.remove(sessionKey);
    }
}
