package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.model.collections.CollectionDetails;
import cn.codingguide.tmdb4j.model.collections.CollectionImagesResponse;
import cn.codingguide.tmdb4j.model.collections.CollectionTranslationsResponse;
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
     * @param language     The language to localize the results (ISO 639-1, optionally with region, e.g., "zh-CN",
     *                     default "en-US").
     *                     结果本地化的语言（ISO 639-1，可选带地区，如 "zh-CN", 默认 "en-US"）。
     * @return Collection details containing metadata and a list of parts.
     * 包含元数据和媒体项列表的合集详情。
     * @see <a href="https://developer.themoviedb.org/reference/collection-details">API LINK</a>
     */
    @GET("collection/{collection_id}")
    Call<CollectionDetails> getCollectionDetails(
            @Path("collection_id") int collectionId,
            @Query("language") String language
    );

    /**
     * Get images (backdrops and posters) for a specific collection.
     * The response includes two lists: backdrops and posters, each containing image metadata.
     * <p>
     * 获取指定合集的图片（背景图和海报）。
     * 响应包含两个列表：背景图和海报，每个列表包含图片的元数据。
     *
     * @param collectionId         The unique identifier of the collection.
     *                             合集的唯一标识符。
     * @param languageCode         Optional language filter (ISO 639-1 code) to limit images to a specific language.
     *                             可选的语言过滤器（ISO 639-1 代码），将图片限制为特定语言。
     * @param includeImageLanguage specify a comma separated list of ISO-639-1 values to query, for example: en-US,null
     *                             额外的图片语言列表，多个用逗号分隔
     * @return CollectionImagesResponse containing backdrops and posters.
     * 包含背景图和海报的合集图片响应。
     * @see <a href="https://developer.themoviedb.org/reference/collection-images">API LINK</a>
     */
    @GET("collection/{collection_id}/images")
    Call<CollectionImagesResponse> getCollectionImages(
            @Path("collection_id") int collectionId,
            @Query("language") String languageCode,
            @Query("include_image_language") String includeImageLanguage
    );

    /**
     * Get a list of translations for a specific collection.
     * Each translation contains language metadata and the translated title, overview, and homepage.
     * <p>
     * 获取指定合集的翻译列表。
     * 每个翻译包含语言元数据以及翻译后的标题、概述和主页。
     *
     * @param collectionId The unique identifier of the collection.
     *                     合集的唯一标识符。
     * @return CollectionTranslationsResponse containing the list of translations.
     * 包含翻译列表的合集翻译响应。
     * @see <a href="https://developer.themoviedb.org/reference/collection-translations">API LINK</a>
     */
    @GET("collection/{collection_id}/translations")
    Call<CollectionTranslationsResponse> getCollectionTranslations(
            @Path("collection_id") int collectionId
    );

}
