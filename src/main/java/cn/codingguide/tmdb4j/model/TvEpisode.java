package cn.codingguide.tmdb4j.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Tv剧集基础信息
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class TvEpisode {

    /**
     * 剧集的首播日期，格式为 YYYY-MM-DD
     */
    @SerializedName("air_date")
    private String airDate;

    /**
     * 剧集在本季中的编号
     */
    @SerializedName("episode_number")
    private int episodeNumber;

    /**
     * 剧集的唯一标识符
     */
    private int id;

    /**
     * 剧集的名称
     */
    private String name;

    /**
     * 剧集的剧情简介
     */
    private String overview;

    /**
     * 剧集的制作代码
     */
    @SerializedName("production_code")
    private String productionCode;

    /**
     * 剧集的时长（分钟）
     */
    private int runtime;

    /**
     * 剧集所属的季号
     */
    @SerializedName("season_number")
    private int seasonNumber;

    /**
     * 剧集所属的电视剧ID
     */
    @SerializedName("show_id")
    private int showId;

    /**
     * 剧集静态图片（剧照）的路径。获取完整图片 URL 需与 TMDB 的图片基础 URL 拼接
     */
    @SerializedName("still_path")
    private String stillPath;

    /**
     * 所有用户评分的平均值，满分10分
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * 为该剧集投票的总用户人数
     */
    @SerializedName("vote_count")
    private int voteCount;

}
