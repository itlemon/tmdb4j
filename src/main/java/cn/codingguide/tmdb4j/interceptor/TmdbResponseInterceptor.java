package cn.codingguide.tmdb4j.interceptor;

import javax.annotation.Nonnull;
import java.io.IOException;

import cn.codingguide.tmdb4j.exception.TmdbClientErrorException;
import cn.codingguide.tmdb4j.exception.TmdbServerErrorException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public class TmdbResponseInterceptor implements Interceptor {

    @Override
    public @Nonnull Response intercept(@Nonnull Interceptor.Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.isSuccessful()) {
            // 尝试解析 TMDB 错误体
            String errorBody = response.body() != null ? response.body().string() : "";
            try {
                // 假设使用 Gson 解析
                JsonObject json = JsonParser.parseString(errorBody).getAsJsonObject();
                if (json.has("status_code") && json.has("status_message")) {
                    int tmdbCode = json.get("status_code").getAsInt();
                    String tmdbMsg = json.get("status_message").getAsString();
                    throw new TmdbClientErrorException(
                            tmdbMsg, response.code(), tmdbCode, tmdbMsg);
                }
            } catch (JsonSyntaxException e) {
                // 无法解析 TMDB 格式，抛出通用 HTTP 异常
            }
            // 根据 HTTP 状态码分类
            if (response.code() >= 400 && response.code() < 500) {
                throw new TmdbClientErrorException(
                        "Client error: " + response.code(), response.code(), 0, "");
            } else if (response.code() >= 500) {
                throw new TmdbServerErrorException(
                        "Server error: " + response.code(), response.code());
            }
        }
        return response;
    }
}
