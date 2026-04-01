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

    @GET("authentication/token/new")
    Call<RequestTokenResponse> createRequestToken();

    @POST("authentication/token/validate_with_login")
    Call<RequestTokenResponse> validateWithLogin(@Body LoginRequest loginRequest);

    @POST("authentication/session/new")
    Call<SessionResponse> createSession(@Query("request_token") String requestToken);

    @DELETE("authentication/session")
    Call<BaseResponse> deleteSession(@Query("session_id") String sessionId);

    @GET("authentication/guest_session/new")
    Call<GuestSessionResponse> createGuestSession();

}
