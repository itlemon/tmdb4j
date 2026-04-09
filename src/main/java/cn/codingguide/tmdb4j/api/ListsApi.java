package cn.codingguide.tmdb4j.api;

import cn.codingguide.tmdb4j.annotation.RequiresSession;
import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.codingguide.tmdb4j.model.lists.AddItemRequest;
import cn.codingguide.tmdb4j.model.lists.CreateListRequest;
import cn.codingguide.tmdb4j.model.lists.CreateListResponse;
import cn.codingguide.tmdb4j.model.lists.ItemStatusResponse;
import cn.codingguide.tmdb4j.model.lists.ListDetails;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@RequiresSession
public interface ListsApi {

    /**
     * Add a movie or TV series to a user-defined list.
     * Requires a valid session ID (via authentication or guest session).
     * <p>
     * 向用户自定义列表中添加电影或电视剧。
     * 需要有效的会话 ID（通过用户认证或游客会话）。
     *
     * @param listId  The ID of the list.
     *                列表的 ID。
     * @param request The request body containing media_type and media_id.
     *                包含 media_type 和 media_id 的请求体。
     * @return BaseResponse indicating success or failure.
     * 表示成功或失败的列表操作响应。
     * @see <a href="https://developer.themoviedb.org/reference/list-add-movie">API LINK</a>
     */
    @POST("list/{list_id}/add_item")
    Call<BaseResponse> addItemToList(
            @Path("list_id") int listId,
            @Body AddItemRequest request
    );

    /**
     * Check if a specific movie or TV series is present in a user-defined list.
     * Requires a valid session ID (via authentication or guest session).
     * <p>
     * 检查用户自定义列表中是否存在特定的电影或电视剧。
     * 需要有效的会话 ID（通过用户认证或游客会话）。
     *
     * @param listId   The ID of the list.
     *                 列表的 ID。
     * @param language Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                 可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param movieId  The ID of the movie to check.
     *                 要检查的电影 ID。
     * @return ItemStatusResponse indicating whether the item exists.
     * 表示项目是否存在的 ItemStatusResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/list-check-item-status">API LINK</a>
     */
    @GET("list/{list_id}/item_status")
    Call<ItemStatusResponse> getItemStatus(
            @Path("list_id") int listId,
            @Query("language") String language,
            @Query("movie_id") int movieId
    );

    /**
     * Clear all items from a user-defined list.
     * Requires a valid session ID (via authentication or guest session).
     * <p>
     * 清空用户自定义列表中的所有项目。
     * 需要有效的会话 ID（通过用户认证或游客会话）。
     *
     * @param listId  The ID of the list.
     *                列表的 ID。
     * @param confirm Must be set to true to confirm the clear operation (e.g., "true"), default false.
     *                必须设置为 true 以确认清空操作（例如 "true"），默认值为false。
     * @return BaseResponse indicating success or failure.
     * 表示成功或失败的 BaseResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/list-clear">API LINK</a>
     */
    @POST("list/{list_id}/clear")
    Call<BaseResponse> clearList(
            @Path("list_id") int listId,
            @Query("confirm") boolean confirm
    );

    /**
     * Create a new user-defined list.
     * Requires a valid session ID (via authentication or guest session).
     * <p>
     * 创建新的用户自定义列表。
     * 需要有效的会话 ID（通过用户认证或游客会话）。
     *
     * @param request The request body containing name, description, and language.
     *                包含名称、描述和语言的请求体。
     * @return CreateListResponse containing the new list ID.
     * 包含新列表 ID 的 CreateListResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/list-create">API LINK</a>
     */
    @POST("list")
    Call<CreateListResponse> createList(
            @Body CreateListRequest request
    );

    /**
     * Delete a user-defined list.
     * Requires a valid session ID (the owner of the list) and a confirm parameter set to true.
     * <p>
     * 删除用户自定义列表。
     * 需要有效的会话 ID（列表所有者）且 confirm 参数必须为 true。
     *
     * @param listId The ID of the list.
     *               列表的 ID。
     * @return BaseResponse indicating success or failure.
     * 表示成功或失败的 BaseResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/list-delete">API LINK</a>
     */
    @DELETE("list/{list_id}")
    Call<BaseResponse> deleteList(
            @Path("list_id") int listId
    );

    /**
     * Get details of a user-defined list by its ID.
     * Public lists do not require authentication; private lists may require a valid session ID.
     * <p>
     * 根据列表 ID 获取用户自定义列表的详情。
     * 公开列表无需认证；私有列表可能需要有效的会话 ID。
     *
     * @param listId   The ID of the list.
     * @param language Optional ISO 639-1 language code (e.g., "en-US", "zh-CN").
     *                 可选的 ISO 639-1 语言代码（例如 "en-US", "zh-CN"）。
     * @param page     The page number (default 1).
     *                 页码（默认为 1）。
     * @return ListDetails containing list metadata and paginated items.
     * @see <a href="https://developer.themoviedb.org/reference/list-details">API LINK</a>
     */
    @GET("list/{list_id}")
    Call<ListDetails> getListDetails(
            @Path("list_id") int listId,
            @Query("language") String language,
            @Query("page") Integer page
    );

}
