package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.Movie;
import cn.codingguide.tmdb4j.model.MovieResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public interface MoviesApi {

    @GET("movie/{movie_id}")
    Call<Movie> getDetails(@Path("movie_id") int movieId);

    @GET("movie/popular")
    Call<MovieResults> getPopular(@Query("page") int page);

}
