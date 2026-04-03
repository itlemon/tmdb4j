package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.collections.CollectionDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface CollectionsApi {

    /**
     * Get details of a movie collection (e.g., "Star Wars Collection").
     * The response includes collection information and the list of movies/TV shows in the collection.
     * <p>
     * 获取电影合集的详细信息（例如“星球大战合集”）。
     * 响应包含合集信息以及合集内的电影/电视剧列表。
     *
     * @param collectionId The unique identifier of the collection.
     *                     合集的唯一标识符。
     * @param language     The language to localize the results (ISO 639-1, optionally with region, e.g., "zh-CN").
     *                     结果本地化的语言（ISO 639-1，可选带地区，如 "zh-CN"）。
     * @return Collection details containing metadata and a list of parts.
     * 包含元数据和媒体项列表的合集详情。
     */
    @GET("collection/{collection_id}")
    Call<CollectionDetails> getCollectionDetails(
            @Path("collection_id") int collectionId,
            @Query("language") String language
    );

}
