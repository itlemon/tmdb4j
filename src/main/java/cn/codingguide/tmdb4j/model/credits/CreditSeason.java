package cn.codingguide.tmdb4j.model.credits;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a season of a TV show in the credit response.
 * Contains season metadata such as air date, poster, episode count, etc.
 * <p>
 * 表示演职员响应中电视剧的一季。
 * 包含季元数据，如播出日期、海报、集数等。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CreditSeason {

    /**
     * The unique identifier of the season.
     * 季的唯一标识符。
     */
    private int id;

    /**
     * The name of the season (e.g., "Season 1").
     * 季的名称（例如 "Season 1"）。
     */
    private String name;

    /**
     * The overview/description of the season.
     * 季的概述/描述。
     */
    private String overview;

    /**
     * The poster image path of the season. Append to TMDB base URL to get full image.
     * 季的海报图片路径。附加到 TMDB 基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The type of media, typically "tv_season".
     * 媒体类型，通常为 "tv_season"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The average vote score for this season (0-10).
     * 该季的平均评分（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The air date of the season (format: YYYY-MM-DD).
     * 季的播出日期（格式：YYYY-MM-DD）。
     */
    @SerializedName("air_date")
    private String airDate;

    /**
     * The season number.
     * 季号。
     */
    @SerializedName("season_number")
    private int seasonNumber;

    /**
     * The ID of the TV show this season belongs to.
     * 季所属的电视剧 ID。
     */
    @SerializedName("show_id")
    private int showId;

    /**
     * The number of episodes in this season.
     * 该季的剧集数量。
     */
    @SerializedName("episode_count")
    private int episodeCount;

}
