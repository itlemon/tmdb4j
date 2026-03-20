package cn.codingguide.tmdb4j.interceptor;

import static cn.codingguide.tmdb4j.constants.TmdbConstants.API_KEY_PARAM_KEY;

import javax.annotation.Nonnull;
import java.io.IOException;

import lombok.AllArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@AllArgsConstructor
public class ApiKeyInterceptor implements Interceptor {

    private final String apiKey;

    @Override
    public @Nonnull Response intercept(@Nonnull Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .url(original.url().newBuilder()
                        .addEncodedQueryParameter(API_KEY_PARAM_KEY, apiKey)
                        .build())
                .build();
        return chain.proceed(request);
    }
}
