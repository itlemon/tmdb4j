package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.constants.MediaType;
import cn.codingguide.tmdb4j.model.lists.AddItemRequest;
import cn.codingguide.tmdb4j.model.lists.CreateListRequest;
import cn.codingguide.tmdb4j.model.lists.RemoveItemRequest;
import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
public class ListTest extends BaseTest {

    @Test
    public void addItemToList() {
        System.out.println(gson.toJson(tmdbClient.addItemToList(
                8515015, AddItemRequest.builder()
                        .mediaType(MediaType.movie)
                        .mediaId(1084187)
                        .build()))
        );
    }

    @Test
    public void getItemStatus() {
        System.out.println(gson.toJson(tmdbClient.getItemStatus(8644603, "en-US", 83533)));
    }

    @Test
    public void clearList() {
        System.out.println(gson.toJson(tmdbClient.clearList(8515015, true)));
    }

    @Test
    public void createList() {
        System.out.println(gson.toJson(tmdbClient.createList(CreateListRequest.builder()
                .name("testItlemon")
                .description("testDescription")
                .language("en-US")
                .build())));
    }

    @Test
    public void deleteList() {
        System.out.println(gson.toJson(tmdbClient.deleteList(8644602)));
    }

    @Test
    public void getListDetails() {
        System.out.println(gson.toJson(tmdbClient.getListDetails(8644603, "zh-CN", 1)));
    }

    @Test
    public void removeItemFromList() {
        System.out.println(gson.toJson(tmdbClient.removeItemFromList(8644603, RemoveItemRequest.builder()
                .mediaId(76479)
                .mediaType(MediaType.tv)
                .build())));
    }

}
