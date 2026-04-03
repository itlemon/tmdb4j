package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.credits.CreditResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface CreditsApi {

    /**
     * Get details of a credit (cast/crew) by its ID.
     * The response includes information about the credit type, media, and person.
     * <p>
     * 根据演职员记录 ID 获取详情。
     * 响应包含演职员类型、关联媒体和人员的信息。
     *
     * @param creditId The unique identifier of the credit.
     *                 演职员记录的唯一标识符。
     * @return CreditResponse containing the credit details.
     * 包含演职员详情的 CreditResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/credit-details">API LINK</a>
     */
    @GET("credit/{credit_id}")
    Call<CreditResponse> getCreditDetails(
            @Path("credit_id") String creditId,
            @Query("language") String language
    );

}
