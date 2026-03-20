package cn.codingguide.tmdb4j.interceptor;

import static cn.codingguide.tmdb4j.constants.TmdbConstants.API_KEY_PARAM_KEY;

import javax.annotation.Nonnull;
import java.io.IOException;

import cn.codingguide.tmdb4j.auth.AuthMethod;
import com.google.common.net.HttpHeaders;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class ApiKeyInterceptor implements Interceptor {

    private final String apiKey;
    private final String bearerToken;
    private final AuthMethod authMethod;

    /**
     * 使用 API Key 作为查询参数（旧方式）
     */
    public ApiKeyInterceptor(String apiKey) {
        this(apiKey, null, AuthMethod.API_KEY_QUERY);
    }

    /**
     * 使用 Bearer Token（推荐）
     */
    public ApiKeyInterceptor(String bearerToken, AuthMethod authMethod) {
        this(null, bearerToken, authMethod);
    }

    public ApiKeyInterceptor(String apiKey, String bearerToken, AuthMethod authMethod) {
        this.apiKey = apiKey;
        this.bearerToken = bearerToken;
        this.authMethod = authMethod;
    }

    @Override
    public @Nonnull Response intercept(@Nonnull Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        requestBuilder.addHeader(HttpHeaders.ACCEPT, "application/json");

        if (authMethod == AuthMethod.BEARER_TOKEN) {
            requestBuilder.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken);
        } else {
            // API_KEY_QUERY: 将 api_key 添加到 URL 查询参数
            requestBuilder.url(original.url().newBuilder()
                    .addEncodedQueryParameter(API_KEY_PARAM_KEY, apiKey)
                    .build());
        }

        return chain.proceed(requestBuilder.build());
    }
}
