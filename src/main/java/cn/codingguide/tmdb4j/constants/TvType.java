package cn.codingguide.tmdb4j.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.Getter;

/**
 * Enum representing the type of a TV series.
 * Used in discover/tv endpoint's "with_type" parameter.
 * <p>
 * 表示电视剧类型的枚举。
 * 用于 discover/tv 端点的 "with_type" 参数。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
public enum TvType {

    /**
     * Documentary.
     * 纪录片。
     */
    DOCUMENTARY(0, "Documentary"),

    /**
     * News program.
     * 新闻节目。
     */
    NEWS(1, "News"),

    /**
     * Miniseries (limited series).
     * 迷你剧（限定剧）。
     */
    MINISERIES(2, "Miniseries"),

    /**
     * Reality TV.
     * 真人秀。
     */
    REALITY(3, "Reality"),

    /**
     * Scripted series (drama, comedy, etc.).
     * 有剧本的剧集（剧情、喜剧等）。
     */
    SCRIPTED(4, "Scripted"),

    /**
     * Talk show.
     * 脱口秀。
     */
    TALK_SHOW(5, "Talk Show"),

    /**
     * Video content.
     * 视频内容。
     */
    VIDEO(6, "Video");

    private final int code;
    private final String description;

    TvType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Returns a pipe-separated string of tv type codes.
     *
     * @param types tv types to combine
     * @return combined string like "1|2|3"
     */
    public static String toPipeSeparated(TvType... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining("|"));
    }

    /**
     * Returns a comma-separated string of tv type codes.
     *
     * @param types tv types to combine
     * @return combined string like "1,2,3"
     */
    public static String toCommaSeparated(TvType... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining(","));
    }

    /**
     * Get TvType enum from numeric code.
     * @param code numeric type code
     * @return corresponding TvType
     * @throws IllegalArgumentException if code is invalid
     */
    public static TvType fromCode(int code) {
        for (TvType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TvType code: " + code);
    }

}
