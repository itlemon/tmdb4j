package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
public class MovieTest extends BaseTest {

    @Test
    public void getNowPlaying() {
        System.out.println(gson.toJson(tmdbClient.getNowPlaying("en-US", null, null)));
    }

    @Test
    public void getUpcoming() {
        System.out.println(gson.toJson(tmdbClient.getUpcoming("en-US", null, null)));
    }

    @Test
    public void getPopularMovies() {
        System.out.println(gson.toJson(tmdbClient.getPopularMovies("en-US", null, null)));
    }

    @Test
    public void getTopRatedMovies() {
        System.out.println(gson.toJson(tmdbClient.getTopRatedMovies("en-US", null, null)));
    }

    @Test
    public void getMovieDetails() {
        System.out.println(gson.toJson(tmdbClient.getMovieDetails(83533, null, null)));
    }
}
