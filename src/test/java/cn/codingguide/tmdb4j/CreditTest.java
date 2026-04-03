package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class CreditTest extends BaseTest {

    @Test
    public void getCreditDetails() {
        System.out.println(gson.toJson(tmdbClient.getCreditDetails("6024a814c0ae36003d59cc3c", "zh-CN")));
    }

}
