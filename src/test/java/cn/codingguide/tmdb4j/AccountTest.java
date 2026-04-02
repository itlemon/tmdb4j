package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.constants.MediaType;
import cn.codingguide.tmdb4j.constants.SortBy;
import cn.codingguide.tmdb4j.model.FavoriteRequest;
import cn.codingguide.tmdb4j.model.WatchlistRequest;
import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-01
 */
public class AccountTest extends BaseTest {

    @Test
    public void getAccountDetails() {
        System.out.println(tmdbClient.getAccountDetails(accountId));
    }

    @Test
    public void addFavorite() {
        System.out.println(tmdbClient.addFavorite(accountId, new FavoriteRequest(MediaType.movie, 83533, true)));
    }

    @Test
    public void addToWatchlist() {
        System.out.println(tmdbClient.addToWatchlist(accountId, new WatchlistRequest(MediaType.movie, 83533, true)));
    }

    @Test
    public void getFavoriteMovies() {
        System.out.println(tmdbClient.getFavoriteMovies(accountId, "en-US", 1, SortBy.CREATED_AT_ASC));
    }

    @Test
    public void getFavoriteTvs() {
        System.out.println(tmdbClient.getFavoriteTvs(accountId, "en-US", 1, SortBy.CREATED_AT_ASC));
    }

    @Test
    public void getCustomLists() {
        System.out.println(tmdbClient.getCustomLists(accountId, 1));
    }

}
