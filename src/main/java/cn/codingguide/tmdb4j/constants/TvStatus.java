package cn.codingguide.tmdb4j.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.Getter;

/**
 * Enum representing the status of a TV series.
 * Used in discover/tv endpoint's "with_status" parameter.
 * <p>
 * 表示电视剧状态的枚举。
 * 用于 discover/tv 端点的 "with_status" 参数。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
public enum TvStatus {

    /**
     * Returning series, regularly airing new episodes.
     * 播出中，定期播出新剧集。
     */
    RETURNING_SERIES(0, "Returning Series"),

    /**
     * Planned, announced but not yet in production.
     * 计划中，已预定但未开始制作。
     */
    PLANNED(1, "Planned"),

    /**
     * In production, currently filming or in post-production.
     * 制作中，正在拍摄或后期制作。
     */
    IN_PRODUCTION(2, "In Production"),

    /**
     * Ended, no new episodes will be produced.
     * 已完结，不再有新剧集。
     */
    ENDED(3, "Ended"),

    /**
     * Cancelled, terminated by the network or platform.
     * 已取消，被电视台或平台终止。
     */
    CANCELLED(4, "Cancelled"),

    /**
     * Pilot, only a pilot episode was produced.
     * 试播集，仅制作了试播集。
     */
    PILOT(5, "Pilot");

    private final int code;
    private final String description;

    TvStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Returns a pipe-separated string of tv status codes.
     *
     * @param types tv status to combine
     * @return combined string like "1|2|3"
     */
    public static String toPipeSeparated(TvStatus... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining("|"));
    }

    /**
     * Returns a comma-separated string of tv status codes.
     *
     * @param types tv status to combine
     * @return combined string like "1,2,3"
     */
    public static String toCommaSeparated(TvStatus... types) {
        return Arrays.stream(types)
                .map(type -> String.valueOf(type.code))
                .collect(Collectors.joining(","));
    }

    /**
     * Get TvStatus enum from numeric code.
     *
     * @param code numeric status code
     * @return corresponding TvStatus
     * @throws IllegalArgumentException if code is invalid
     */
    public static TvStatus fromCode(int code) {
        for (TvStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid TvStatus code: " + code);
    }
}
