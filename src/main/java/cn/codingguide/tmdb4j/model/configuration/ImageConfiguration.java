package cn.codingguide.tmdb4j.model.configuration;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the image configuration section of the TMDB configuration API.
 * Contains base URLs and available size options for posters, backdrops, logos, and profile images.
 * <p>
 * 表示 TMDB 配置 API 中的图片配置部分。
 * 包含基础 URL 以及海报、背景图、标志和个人头像的可用尺寸选项。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class ImageConfiguration {

    /**
     * The base URL for TMDB images (HTTP).
     * TMDB 图片的基础 URL（HTTP）。
     */
    @SerializedName("base_url")
    private String baseUrl;

    /**
     * The secure base URL for TMDB images (HTTPS).
     * TMDB 图片的安全基础 URL（HTTPS）。
     */
    @SerializedName("secure_base_url")
    private String secureBaseUrl;

    /**
     * Available sizes for backdrop images (e.g., "w300", "w780", "w1280", "original").
     * 背景图片的可用尺寸（例如 "w300", "w780", "w1280", "original"）。
     */
    @SerializedName("backdrop_sizes")
    private List<String> backdropSizes;

    /**
     * Available sizes for logo images (e.g., "w45", "w92", "w154", "w185", "w300", "w500", "original").
     * 标志图片的可用尺寸（例如 "w45", "w92", "w154", "w185", "w300", "w500", "original"）。
     */
    @SerializedName("logo_sizes")
    private List<String> logoSizes;

    /**
     * Available sizes for poster images (e.g., "w92", "w154", "w185", "w342", "w500", "w780", "original").
     * 海报图片的可用尺寸（例如 "w92", "w154", "w185", "w342", "w500", "w780", "original"）。
     */
    @SerializedName("poster_sizes")
    private List<String> posterSizes;

    /**
     * Available sizes for profile images (e.g., "w45", "w185", "h632", "original").
     * 个人头像的可用尺寸（例如 "w45", "w185", "h632", "original"）。
     */
    @SerializedName("profile_sizes")
    private List<String> profileSizes;

    /**
     * Available sizes for still images (e.g., "w92", "w185", "w300", "original").
     * 剧照图片的可用尺寸（例如 "w92", "w185", "w300", "original"）。
     */
    @SerializedName("still_sizes")
    private List<String> stillSizes;

}
