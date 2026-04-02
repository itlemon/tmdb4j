package cn.codingguide.tmdb4j.interceptor;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import cn.codingguide.tmdb4j.exception.TmdbClientErrorException;
import cn.codingguide.tmdb4j.exception.TmdbServerErrorException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
public class TmdbResponseInterceptor implements Interceptor {

    private static final Gson gson = new Gson();

    // TMDB 成功状态码（根据官方文档）https://developer.themoviedb.org/docs/errors
    private static final Set<Integer> SUCCESS_CODES = Sets.newHashSet(1, 12, 13);

    @Override
    public @Nonnull Response intercept(@Nonnull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (response.isSuccessful()) {
            // 成功响应仍需检查业务状态码（TMDB 可能返回 200 但 status_code 不是成功码）
            String bodyString = null;
            ResponseBody body = response.body();
            if (body != null) {
                bodyString = body.string();
                // 获取 Content-Type，若为 null 则使用默认 JSON 类型
                MediaType mediaType = body.contentType();
                if (mediaType == null) {
                    mediaType = MediaType.parse("application/json; charset=utf-8");
                }

                // 重新包装 body 以便后续使用（因为流只能读一次）
                response = response.newBuilder()
                        .body(ResponseBody.create(mediaType, ByteString.encodeString(bodyString, StandardCharsets.UTF_8)))
                        .build();
            }
            // 解析业务状态码
            if (StrUtil.isNotBlank(bodyString)) {
                try {
                    JsonObject json = gson.fromJson(bodyString, JsonObject.class);
                    if (json.has("status_code")) {
                        int statusCode = json.get("status_code").getAsInt();
                        if (!SUCCESS_CODES.contains(statusCode)) {
                            // 业务错误，抛出客户端异常
                            String message = json.has("status_message") ?
                                    json.get("status_message").getAsString() : "Unknown error";
                            throw new TmdbClientErrorException(message, response.code(), statusCode, message);
                        }
                    }
                } catch (JsonSyntaxException e) {
                    // 响应不是 JSON，忽略（可能不是 TMDB 标准错误格式）
                }
            }
            return response;
        } else {
            // HTTP 错误
            int httpCode = response.code();
            String errorBody = "";
            try (ResponseBody body = response.body()) {
                if (body != null) {
                    errorBody = body.string();
                }
            } catch (IOException ignored) {
            }

            // 尝试解析 TMDB 错误格式
            try {
                JsonObject json = gson.fromJson(errorBody, JsonObject.class);
                if (json.has("status_code") && json.has("status_message")) {
                    int tmdbCode = json.get("status_code").getAsInt();
                    String tmdbMsg = json.get("status_message").getAsString();
                    throw new TmdbClientErrorException(tmdbMsg, httpCode, tmdbCode, tmdbMsg);
                }
            } catch (JsonSyntaxException ignored) {
                // 不是标准错误格式
            }

            // 根据 HTTP 状态码分类
            if (httpCode >= HttpStatus.HTTP_BAD_REQUEST && httpCode < HttpStatus.HTTP_INTERNAL_ERROR) {
                throw new TmdbClientErrorException("HTTP client error: " + httpCode, httpCode, 0, errorBody);
            } else if (httpCode >= HttpStatus.HTTP_INTERNAL_ERROR) {
                throw new TmdbServerErrorException("HTTP server error: " + httpCode, httpCode);
            } else {
                // 其他（如 3xx 重定向等），一般不会出现，按通用异常处理
                throw new TmdbClientErrorException("Unexpected HTTP response: " + httpCode, httpCode, 0, errorBody);
            }
        }
    }
}
