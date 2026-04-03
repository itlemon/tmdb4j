package cn.codingguide.tmdb4j.model.tvs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an episode of a TV series from TMDB.
 * Contains episode metadata such as episode number, season number, air date, and runtime.
 * <p>
 * 表示 TMDB 中电视剧的一集。
 * 包含剧集元数据，如集数、季数、播出日期和时长。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class TvEpisode {

    /**
     * The air date of the episode, formatted as YYYY-MM-DD.
     * 剧集的播出日期，格式为 YYYY-MM-DD。
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
     * The ID of the TV series this episode belongs to.
     * 剧集所属的电视剧 ID。
     */
    @SerializedName("show_id")
    private int showId;

    /**
     * The still image path of the episode.
     * Append this to the TMDB image base URL to get the full image.
     * 剧集的静态图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("still_path")
    private String stillPath;

    /**
     * The average vote score (0-10) for this episode.
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

}
