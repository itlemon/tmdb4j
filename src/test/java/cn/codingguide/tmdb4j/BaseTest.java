package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.session.DefaultSessionKeyProvider;
import cn.codingguide.tmdb4j.session.InMemorySessionStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-01
 */
public class BaseTest {

    protected static final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    protected static String apiKey;
    protected static String sessionId;

    protected static String username;
    protected static String password;
    protected static int accountId;

    protected static TmdbClient tmdbClient;

    @BeforeAll
    public static void tmdbClient() {
        apiKey = System.getenv("TMDB_API_KEY");
        sessionId = System.getenv("TMDB_SESSION_ID");
        username = System.getenv("TMDB_USERNAME");
        password = System.getenv("TMDB_PASSWORD");
        accountId = Integer.parseInt(System.getenv("TMDB_ACCOUNT_ID"));

        tmdbClient = new TmdbClient.Builder(apiKey)
                .sessionStore(new InMemorySessionStore())
                .sessionKeyProvider(new DefaultSessionKeyProvider(() -> "test"))
                .build();
        // 用于测试的正式会话ID
        tmdbClient.saveSession(sessionId);
    }

}
