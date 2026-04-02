package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
public class ChangeTest extends BaseTest {

    @Test
    public void getMovieChanges() {
        System.out.println(tmdbClient.getMovieChanges(1, "", ""));
    }
}
