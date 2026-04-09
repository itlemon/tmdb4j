package cn.codingguide.tmdb4j.model.lists;

import java.util.List;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * An item (movie or TV series) inside a user-defined list.
 * Contains fields common to both movies and TV series, with media_type to distinguish.
 * <p>
 * 用户自定义列表中的项目（电影或电视剧）。
 * 包含电影和电视剧共有的字段，通过 media_type 区分。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class ListItem {

    /**
     * Indicates whether the content is adult-only.
     * 表示是否仅限成人内容。
     */
    private boolean adult;

    /**
     * The backdrop image path.
     * 背景图片路径。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The unique identifier.
     * 唯一标识符。
     */
    private int id;

    // 电影专用字段
    /**
     * The title of the movie (only for movies).
     * 电影的标题（仅用于电影）。
     */
    private String title;

    /**
     * The original title of the movie (only for movies).
     * 电影的原始标题（仅用于电影）。
     */
    @SerializedName("original_title")
    private String originalTitle;

    /**
     * The release date of the movie (format: YYYY-MM-DD).
     * 电影的上映日期（格式：YYYY-MM-DD）。
     */
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * Indicates whether the movie has a video (e.g., trailer).
     * 表示电影是否有视频（如预告片）。
     */
    private boolean video;

    // 电视剧专用字段
    /**
     * The name of the TV series (only for TV).
     * 电视剧的名称（仅用于电视剧）。
     */
    private String name;

    /**
     * The original name of the TV series (only for TV).
     * 电视剧的原始名称（仅用于电视剧）。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The first air date of the TV series (format: YYYY-MM-DD).
     * 电视剧的首播日期（格式：YYYY-MM-DD）。
     */
    @SerializedName("first_air_date")
    private String firstAirDate;

    /**
     * The origin country codes (ISO 3166-1) for TV series.
     * 电视剧的原始国家/地区代码列表。
     */
    @SerializedName("origin_country")
    private List<String> originCountry;

    // 公共字段
    /**
     * The overview/description.
     * 概述/描述。
     */
    private String overview;

    /**
     * The poster image path.
     * 海报图片路径。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The type of media: "movie" or "tv".
     * 媒体类型："movie" 或 "tv"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The original language code (ISO 639-1).
     * 原始语言代码（ISO 639-1）。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * List of genre IDs.
     * 类型 ID 列表。
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * The popularity score.
     * 热度指数。
     */
    private double popularity;

    /**
     * The average vote score (0-10).
     * 平均评分（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The number of votes.
     * 投票人数。
     */
    @SerializedName("vote_count")
    private int voteCount;

}
