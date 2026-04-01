package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.annotation.RequiresSession;
import cn.codingguide.tmdb4j.model.Account;
import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.model.FavoriteRequest;
import cn.codingguide.tmdb4j.model.MovieResults;
import cn.codingguide.tmdb4j.model.RatingRequest;
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

    @GET("account")
    Call<Account> getAccountDetails();

    @GET("account/{account_id}/favorite/movies")
    Call<MovieResults> getFavoriteMovies(
            @Path("account_id") int accountId,
            @Query("page") int page
    );

    @POST("account/{account_id}/favorite")
    Call<BaseResponse> markAsFavorite(
            @Path("account_id") int accountId,
            @Body FavoriteRequest request
    );

    @POST("movie/{movie_id}/rating")
    Call<BaseResponse> rateMovie(
            @Path("movie_id") int movieId,
            @Body RatingRequest rating
    );

}
