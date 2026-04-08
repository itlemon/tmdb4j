package cn.codingguide.tmdb4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Retrofit interface method marked requires TMDB Session ID authentication. Methods annotated with this
 * annotation will automatically add the session_id parameter during the request.
 * <p>
 * 标记 Retrofit 接口方法需要 TMDB Session ID 认证。
 * 使用该注解的方法会在请求时自动添加 session_id 参数。
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequiresSession {

}
