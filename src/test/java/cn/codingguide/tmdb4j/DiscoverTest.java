package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.constants.SortBy;
import cn.codingguide.tmdb4j.model.discover.MovieDiscoverOptions;
import cn.codingguide.tmdb4j.model.discover.TvDiscoverOptions;
import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class DiscoverTest extends BaseTest {

    @Test
    public void discoverMovies() {
        System.out.println(gson.toJson(tmdbClient.discoverMovies(
                MovieDiscoverOptions.builder()
                        .withRuntimeLte(110)
                        .withRuntimeGte(60)
                        .sortBy(SortBy.POPULARITY_DESC)
                        .page(1)
                        .build()
        )));
    }

    @Test
    public void discoverTvs() {
        System.out.println(gson.toJson(tmdbClient.discoverTvs(
                TvDiscoverOptions.builder()
                        .withRuntimeLte(110)
                        .withRuntimeGte(60)
                        .sortBy(SortBy.POPULARITY_DESC)
                        .page(1)
                        .build()
        )));
    }

}
