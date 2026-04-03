package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class CompanyTest extends BaseTest {

    @Test
    public void getCompanyDetails() {
        System.out.println(gson.toJson(tmdbClient.getCompanyDetails(23)));
    }

    @Test
    public void getCompanyAlternativeNames() {
        System.out.println(gson.toJson(tmdbClient.getCompanyAlternativeNames(23)));
    }

    @Test
    public void getCompanyImages() {
        System.out.println(gson.toJson(tmdbClient.getCompanyImages(23)));
    }

}
