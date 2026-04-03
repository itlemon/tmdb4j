package cn.codingguide.tmdb4j.constants;

import lombok.Getter;

/**
 * Enum representing the possible external sources for the find endpoint.
 * Used to specify where the external ID comes from.
 * <p>
 * 表示查找端点支持的外部来源枚举。
 * 用于指定外部 ID 的来源。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
public enum ExternalSource {

    /**
     * IMDb ID (e.g., "tt1375666").
     * IMDb 标识符（例如 "tt1375666"）。
     */
    IMDB_ID("imdb_id"),

    /**
     * Facebook ID.
     * Facebook 标识符。
     */
    FACEBOOK_ID("facebook_id"),

    /**
     * Instagram ID.
     * Instagram 标识符。
     */
    INSTAGRAM_ID("instagram_id"),

    /**
     * Twitter ID.
     * Twitter 标识符。
     */
    TWITTER_ID("twitter_id"),

    /**
     * TVDB ID (TheTVDB.com identifier).
     * TVDB 标识符（TheTVDB.com）。
     */
    TVDB_ID("tvdb_id"),

    /**
     * TikTok ID.
     * TikTok 标识符。
     */
    TIKTOK_ID("tiktok_id"),

    /**
     * YouTube ID.
     * YouTube 标识符。
     */
    YOUTUBE_ID("youtube_id"),

    /**
     * Wikidata ID.
     * 维基数据标识符。
     */
    WIKIDATA_ID("wikidata_id");

    private final String value;

    ExternalSource(String value) {
        this.value = value;
    }

    /**
     * Get ExternalSource enum from its string value.
     * @param value the string value (e.g., "imdb_id")
     * @return corresponding ExternalSource
     * @throws IllegalArgumentException if value is not recognized
     */
    public static ExternalSource fromValue(String value) {
        for (ExternalSource source : values()) {
            if (source.value.equals(value)) {
                return source;
            }
        }
        throw new IllegalArgumentException("Unknown external source: " + value);
    }

}
