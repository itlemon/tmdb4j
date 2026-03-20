package cn.codingguide.tmdb4j.interceptor;

import static cn.codingguide.tmdb4j.constants.TmdbConstants.SESSION_ID_PARAM_KEY;
import static cn.hutool.http.HttpStatus.HTTP_FORBIDDEN;
import static cn.hutool.http.HttpStatus.HTTP_UNAUTHORIZED;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.lang.reflect.Method;

import cn.codingguide.tmdb4j.annotation.RequiresSession;
import cn.codingguide.tmdb4j.exception.TmdbIOException;
import cn.codingguide.tmdb4j.exception.TmdbSessionException;
import cn.codingguide.tmdb4j.session.SessionKeyProvider;
import cn.codingguide.tmdb4j.session.SessionStore;
import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Invocation;

/**
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@AllArgsConstructor
public class SessionInterceptor implements Interceptor {

    private final SessionStore sessionStore;
    private final SessionKeyProvider sessionKeyProvider;

    @Override
    public @Nonnull Response intercept(@Nonnull Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        if (!requiresSession(original)) {
            // 不需要会话，直接放行
            return chain.proceed(original);
        }

        // 获取会话键
        String sessionKey = sessionKeyProvider.getSessionKey();
        if (StrUtil.isBlank(sessionKey)) {
            throw new TmdbSessionException("SessionKeyProvider returned null, cannot identify session");
        }

        // 获取会话ID
        String sessionId = sessionStore.get(sessionKey);
        if (StrUtil.isBlank(sessionId)) {
            throw new TmdbSessionException("No session found for key: " + sessionKey);
        }

        // 注入 session_id 参数
        Request newRequest = original.newBuilder()
                .url(original.url()
                        .newBuilder()
                        .setEncodedQueryParameter(SESSION_ID_PARAM_KEY, sessionId)
                        .build())
                .build();

        Response response;
        try {
            response = chain.proceed(newRequest);
        } catch (IOException e) {
            // 网络/IO 异常包装为 TmdbIOException
            throw new TmdbIOException("Network error during session request", e);
        }

        // 检查 HTTP 状态码表示会话失效（401 Unauthorized 或 403 Forbidden）
        if (response.code() == HTTP_UNAUTHORIZED || response.code() == HTTP_FORBIDDEN) {
            // 清除本地失效会话
            sessionStore.remove(sessionKey);
            // 关闭响应体避免资源泄漏
            response.close();
            throw new TmdbSessionException("Session expired, please re-authenticate");
        }

        return response;
    }

    /**
     * 判断当前请求是否需要注入 session_id。
     * 优先通过 @RequiresSession 注解判断，降级使用路径匹配。
     */
    private boolean requiresSession(Request request) {
        // 通过 Retrofit 的 Invocation 获取被调用的方法
        Invocation invocation = request.tag(Invocation.class);
        if (invocation != null) {
            Method method = invocation.method();
            // 检查方法上是否有 @RequiresSession 注解
            if (method.isAnnotationPresent(RequiresSession.class)) {
                return true;
            }
            // 可选：检查接口类上的注解（如 @RequiresSession 标注在整个接口上）
            if (method.getDeclaringClass().isAnnotationPresent(RequiresSession.class)) {
                return true;
            }
        }

        // TODO 降级方案：基于路径判断（可根据需要保留或删除）
        String path = request.url().encodedPath();
        return path.contains("/account/")
                || (path.contains("/movie/") && "POST".equalsIgnoreCase(request.method()))
                || (path.contains("/tv/") && "POST".equalsIgnoreCase(request.method()));
    }

}
