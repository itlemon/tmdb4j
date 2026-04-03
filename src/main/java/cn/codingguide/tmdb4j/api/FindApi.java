package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.find.FindResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface FindApi {

    /**
     * Find TMDB items by an external ID.
     * <p>
     * 通过外部 ID 查找 TMDB 条目。
     *
     * @param externalId     The external ID to look up.
     *                       要查找的外部 ID。
     * @param externalSource The source of the external ID (use ExternalSource enum).
     *                       外部 ID 的来源（使用 ExternalSource 枚举）。
     * @param language       Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                       可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @return FindResponse containing lists of matching items.
     * 包含匹配项列表的 FindResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/find-by-id">API LINK</a>
     */
    @GET("find/{external_id}")
    Call<FindResponse> findByExternalId(
            @Path("external_id") String externalId,
            @Query("external_source") String externalSource,
            @Query("language") String language
    );

}
