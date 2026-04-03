package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class CollectionTest extends BaseTest {

    @Test
    public void getCollectionDetails() {
        System.out.println(gson.toJson(tmdbClient.getCollectionDetails(87096, "zh-CN")));
    }

    @Test
    public void getCollectionImages() {
        System.out.println(gson.toJson(tmdbClient.getCollectionImages(87096, "zh-CN", null)));
    }

}
