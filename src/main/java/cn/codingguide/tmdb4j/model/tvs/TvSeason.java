package cn.codingguide.tmdb4j.model.tvs;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a season of a TV series from TMDB.
 * <p>
 * 表示 TMDB 中电视剧的一季。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class TvSeason {

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
     * The poster image path of the season.
     * Append this to the TMDB image base URL to get the full image.
     * 季的海报图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

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
     * The ID of the TV series this season belongs to.
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

    /**
     * The average vote score (0-10) for this season.
     * 该季的平均评分（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The number of votes for this season.
     * 该季的投票人数。
     */
    @SerializedName("vote_count")
    private int voteCount;

}
