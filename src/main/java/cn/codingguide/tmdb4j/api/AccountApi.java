package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.annotation.RequiresSession;
import cn.codingguide.tmdb4j.model.Account;
import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.model.CustomList;
import cn.codingguide.tmdb4j.model.FavoriteRequest;
import cn.codingguide.tmdb4j.model.Movie;
import cn.codingguide.tmdb4j.model.PagedResults;
import cn.codingguide.tmdb4j.model.RatedMovie;
import cn.codingguide.tmdb4j.model.RatedTvEpisode;
import cn.codingguide.tmdb4j.model.RatedTvSeries;
import cn.codingguide.tmdb4j.model.RatingRequest;
import cn.codingguide.tmdb4j.model.TvSeries;
import cn.codingguide.tmdb4j.model.WatchlistRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@RequiresSession
public interface AccountApi {

    // https://developer.themoviedb.org/reference/account-details
    @GET("account/{account_id}")
    Call<Account> getAccountDetails(
            @Path("account_id") int accountId
    );

    // https://developer.themoviedb.org/reference/account-add-favorite
    @POST("account/{account_id}/favorite")
    Call<BaseResponse> addFavorite(
            @Path("account_id") int accountId,
            @Body FavoriteRequest request
    );

    // https://developer.themoviedb.org/reference/account-add-to-watchlist
    @POST("account/{account_id}/watchlist")
    Call<BaseResponse> addToWatchlist(
            @Path("account_id") int accountId,
            @Body WatchlistRequest request
    );

    // https://developer.themoviedb.org/reference/account-get-favorites
    @GET("account/{account_id}/favorite/movies")
    Call<PagedResults<Movie>> getFavoriteMovies(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-favorite-tv
    @GET("account/{account_id}/favorite/tv")
    Call<PagedResults<TvSeries>> getFavoriteTvs(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-lists
    @GET("account/{account_id}/lists")
    Call<PagedResults<CustomList>> getCustomLists(
            @Path("account_id") int accountId,
            @Query("page") int page
    );

    // https://developer.themoviedb.org/reference/account-rated-movies
    @GET("account/{account_id}/rated/movies")
    Call<PagedResults<RatedMovie>> getRatedMovies(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-rated-tv
    @GET("account/{account_id}/rated/tv")
    Call<PagedResults<RatedTvSeries>> getRatedTvSeries(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-rated-tv-episodes
    @GET("account/{account_id}/rated/tv/episodes")
    Call<PagedResults<RatedTvEpisode>> getRatedTvEpisodes(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-watchlist-movies
    @GET("account/{account_id}/watchlist/movies")
    Call<PagedResults<Movie>> getWatchlistMovies(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    // https://developer.themoviedb.org/reference/account-watchlist-tv
    @GET("account/{account_id}/watchlist/tv")
    Call<PagedResults<TvSeries>> getWatchlistTvs(
            @Path("account_id") int accountId,
            @Query("language") String language,
            @Query("page") int page,
            @Query("sort_by") String sortBy
    );

    @POST("movie/{movie_id}/rating")
    Call<BaseResponse> rateMovie(
            @Path("movie_id") int movieId,
            @Body RatingRequest rating
    );

}
