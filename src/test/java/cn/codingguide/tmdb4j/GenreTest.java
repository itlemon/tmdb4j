package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class GenreTest extends BaseTest {

    @Test
    public void getMovieGenres() {
        System.out.println(gson.toJson(tmdbClient.getMovieGenres("zh-CN")));
    }

    @Test
    public void getTvGenres() {
        System.out.println(gson.toJson(tmdbClient.getTvGenres("zh-CN")));
    }
}
