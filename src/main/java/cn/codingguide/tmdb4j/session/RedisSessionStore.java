package cn.codingguide.tmdb4j.session;

import java.io.Closeable;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * Redis 存储实现，适用于分布式集群。
 * 注意：TMDB 的 session_id 本身不会过期，但你可以根据业务需要设置存储过期时间。
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class RedisSessionStore implements SessionStore, Closeable {

    private final RedisClient redisClient;
    private final StatefulRedisConnection<String, String> connection;
    private final RedisCommands<String, String> sync;
    // -1 表示永不过期
    private final int expireSeconds;

    /**
     * 创建 Redis 会话存储（永不过期）
     *
     * @param redisClient Lettuce RedisClient
     */
    public RedisSessionStore(RedisClient redisClient) {
        this(redisClient, -1);
    }

    /**
     * 创建 Redis 会话存储（自定义过期时间）
     *
     * @param redisClient   Lettuce RedisClient
     * @param expireSeconds 业务层自定义过期时间（秒），-1 表示永不过期
     */
    public RedisSessionStore(RedisClient redisClient, int expireSeconds) {
        this.redisClient = redisClient;
        this.expireSeconds = expireSeconds;
        this.connection = redisClient.connect();
        this.sync = connection.sync();
    }

    @Override
    public void save(String sessionKey, String sessionId) {
        if (expireSeconds > 0) {
            sync.setex(sessionKey, expireSeconds, sessionId);
        } else {
            sync.set(sessionKey, sessionId);
        }
    }

    @Override
    public String get(String sessionKey) {
        return sync.get(sessionKey);
    }

    @Override
    public void remove(String sessionKey) {
        sync.del(sessionKey);
    }

    /**
     * 关闭 Redis 连接和客户端，释放资源。
     */
    @Override
    public void close() {
        connection.close();
        redisClient.shutdown();
    }
}
