package cn.codingguide.tmdb4j.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.Getter;

/**
 * Release type for a movie.
 * Used in discover filters and movie release data.
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
public enum ReleaseType {

    /**
     * 首映 (Premiere):电影的首次公开放映，多见于电影节
     */
    PREMIERE(1, "Premiere"),

    /**
     * 有限院线上映 (Theatrical Limited):在小范围影院上映，通常指少于特定数量的影院
     */
    THEATRICAL_LIMITED(2, "Theatrical (limited)"),

    /**
     * 院线上映 (Theatrical):电影的正式、大规模公映
     */
    THEATRICAL(3, "Theatrical"),

    /**
     * 数字发行 (Digital):在数字平台（如 iTunes, Amazon, Netflix）上线，即俗称的“流媒体上映”
     */
    DIGITAL(4, "Digital"),

    /**
     * 实体发行 (Physical):以实体介质（如DVD, Blu-ray）发行
     */
    PHYSICAL(5, "Physical"),

    /**
     * 电视播出 (TV):在电视频道首播
     */
    TV(6, "TV");

    private final int code;
    private final String description;

    ReleaseType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Returns a pipe-separated string of release type codes.
     *
     * @param types release types to combine
     * @return combined string like "1|2|3"
     */
    public static String toPipeSeparated(ReleaseType... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining("|"));
    }

    /**
     * Returns a comma-separated string of release type codes.
     *
     * @param types release types to combine
     * @return combined string like "1,2,3"
     */
    public static String toCommaSeparated(ReleaseType... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining(","));
    }

    public static ReleaseType fromCode(int code) {
        for (ReleaseType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ReleaseType code: " + code);
    }
}
