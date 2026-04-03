package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.certifications.CertificationResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
public interface CertificationApi {

    @GET("certification/movie/list")
    Call<CertificationResponse> getMovieCertifications();

    @GET("certification/tv/list")
    Call<CertificationResponse> getTvCertifications();

}
