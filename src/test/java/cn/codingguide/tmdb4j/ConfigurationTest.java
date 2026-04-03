package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public class ConfigurationTest extends BaseTest{

    @Test
    public void getConfigurationDetails() {
        System.out.println(gson.toJson(tmdbClient.getConfigurationDetails()));
    }

    @Test
    public void getCountries() {
        System.out.println(gson.toJson(tmdbClient.getCountries()));
    }

    @Test
    public void getLanguages() {
        System.out.println(gson.toJson(tmdbClient.getLanguages()));
    }

    @Test
    public void getJobs() {
        System.out.println(gson.toJson(tmdbClient.getJobs()));
    }

    @Test
    public void getPrimaryTranslations() {
        System.out.println(gson.toJson(tmdbClient.getPrimaryTranslations()));
    }

    @Test
    public void getTimezones() {
        System.out.println(gson.toJson(tmdbClient.getTimezones()));
    }

}
