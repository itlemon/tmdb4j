package cn.codingguide.tmdb4j.model.credits;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an episode of a TV show in the credit response.
 * Contains episode metadata such as air date, number, runtime, etc.
 * <p>
 * 表示演职员响应中电视剧的一集。
 * 包含剧集元数据，如播出日期、编号、时长等。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CreditEpisode {

    /**
     * The unique identifier of the episode.
     * 剧集的唯一标识符。
     */
    private int id;

    /**
     * The name of the episode.
     * 剧集的名称。
     */
    private String name;

    /**
     * The overview/description of the episode.
     * 剧集的概述/描述。
     */
    private String overview;

    /**
     * The type of media, typically "tv_episode".
     * 媒体类型，通常为 "tv_episode"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The average vote score for this episode (0-10).
     * 该剧集的平均评分（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The number of votes for this episode.
     * 该剧集的投票人数。
     */
    @SerializedName("vote_count")
    private int voteCount;

    /**
     * The air date of the episode (format: YYYY-MM-DD).
     * 剧集的播出日期（格式：YYYY-MM-DD）。
     */
    @SerializedName("air_date")
    private String airDate;

    /**
     * The episode number within its season.
     * 剧集在所属季中的编号。
     */
    @SerializedName("episode_number")
    private int episodeNumber;

    /**
     * The type of episode (e.g., "standard").
     * 剧集的类型（例如 "standard"）。
     */
    @SerializedName("episode_type")
    private String episodeType;

    /**
     * The production code of the episode (may be empty).
     * 剧集的制作代码（可能为空）。
     */
    @SerializedName("production_code")
    private String productionCode;

    /**
     * The runtime of the episode in minutes.
     * 剧集的时长（分钟）。
     */
    private int runtime;

    /**
     * The season number to which this episode belongs.
     * 剧集所属的季号。
     */
    @SerializedName("season_number")
    private int seasonNumber;

    /**
     * The ID of the TV show this episode belongs to.
     * 剧集所属的电视剧 ID。
     */
    @SerializedName("show_id")
    private int showId;

    /**
     * The still image path of the episode. Append to TMDB base URL to get full image.
     * 剧集的静态图片路径。附加到 TMDB 基础 URL 以获取完整图片。
     */
    @SerializedName("still_path")
    private String stillPath;

}
