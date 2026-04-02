package cn.codingguide.tmdb4j;

import cn.codingguide.tmdb4j.model.BaseResponse;
import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;

/**
 * 会话管理接口测试
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-01
 */
public class SessionTest extends BaseTest {

    @Test
    public void createAndSaveGuestSession() {
        String guestSession = tmdbClient.createAndSaveGuestSession();
        System.out.println("访客会话ID：" + guestSession);
        Assert.equals(guestSession, tmdbClient.getCurrentSessionId());
    }

    @Test
    public void loginAndSaveSession() {
        String sessionId = tmdbClient.loginAndSaveSession(username, password);
        System.out.println("正式会话ID：" + sessionId);
        Assert.equals(sessionId, tmdbClient.getCurrentSessionId());
        // 这里可以打断点暂定，然后去tmdb看（https://www.themoviedb.org/settings/api/sessions）具体的sessionId列表
        tmdbClient.logoutAndDeleteSession();
    }

    @Test
    public void validateKey() {
        BaseResponse baseResponse = tmdbClient.validateKey();
        System.out.println(baseResponse);
        Assert.equals(true, baseResponse.isSuccess());
    }

}
