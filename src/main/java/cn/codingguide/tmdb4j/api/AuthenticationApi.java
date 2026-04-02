package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.model.GuestSessionResponse;
import cn.codingguide.tmdb4j.model.LoginRequest;
import cn.codingguide.tmdb4j.model.RequestTokenResponse;
import cn.codingguide.tmdb4j.model.SessionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public interface AuthenticationApi {

    // https://developer.themoviedb.org/reference/authentication-create-request-token
    @GET("authentication/token/new")
    Call<RequestTokenResponse> createRequestToken();

    // https://developer.themoviedb.org/reference/authentication-create-session-from-login
    @POST("authentication/token/validate_with_login")
    Call<RequestTokenResponse> validateWithLogin(@Body LoginRequest loginRequest);

    // https://developer.themoviedb.org/reference/authentication-create-session
    @POST("authentication/session/new")
    Call<SessionResponse> createSession(@Query("request_token") String requestToken);

    // https://developer.themoviedb.org/reference/authentication-delete-session
    @DELETE("authentication/session")
    Call<BaseResponse> deleteSession(@Query("session_id") String sessionId);

    // https://developer.themoviedb.org/reference/authentication-create-guest-session
    @GET("authentication/guest_session/new")
    Call<GuestSessionResponse> createGuestSession();

    // https://developer.themoviedb.org/reference/authentication-validate-key
    @GET("authentication")
    Call<BaseResponse> validateKey();
}
