package cn.codingguide.tmdb4j;

import org.junit.jupiter.api.Test;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
public class CertificationTest extends BaseTest{

    @Test
    public void getMovieCertifications() {
        System.out.println(tmdbClient.getMovieCertifications());
    }

    @Test
    public void getTvCertifications() {
        System.out.println(tmdbClient.getTvCertifications());
    }

}
