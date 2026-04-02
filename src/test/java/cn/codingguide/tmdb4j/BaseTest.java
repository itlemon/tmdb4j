package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.session.DefaultSessionKeyProvider;
import cn.codingguide.tmdb4j.session.InMemorySessionStore;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-01
 */
public class BaseTest {

    protected static TmdbClient tmdbClient;

    @BeforeAll
    public static void tmdbClient() {
        tmdbClient = new TmdbClient.Builder(System.getenv("API_KEY"))
                .sessionStore(new InMemorySessionStore())
                .sessionKeyProvider(new DefaultSessionKeyProvider(() -> "test"))
                .build();
        // 用于测试的正式会话ID
        System.out.println(System.getenv("SESSION_ID"));
        tmdbClient.saveSession(System.getenv("SESSION_ID"));
    }

}
