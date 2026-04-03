package cn.codingguide.tmdb4j.model.collections;

import java.util.List;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a media item (movie or TV show) that is part of a collection.
 * Contains basic information as returned by the collection API.
 * <p>
 * 表示合集中的一个媒体项（电影或电视剧）。
 * 包含合集 API 返回的基本信息。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CollectionPart {

    /**
     * Indicates whether the item is considered adult content.
     * 表示该内容是否属于成人内容。
     */
    private boolean adult;

    /**
     * The backdrop image path.
     * Append this to the TMDB image base URL to get the full image.
     * 背景图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The unique identifier of the movie or TV show.
     * 电影或电视剧的唯一标识符。
     */
    private int id;

    /**
     * The title of the movie or TV show (localized).
     * 电影或电视剧的名称（本地化）。
     */
    private String title;

    /**
     * The original title of the movie or TV show.
     * 电影或电视剧的原始名称。
     */
    @SerializedName("original_title")
    private String originalTitle;

    /**
     * The overview/description of the movie or TV show.
     * 电影或电视剧的概述/描述。
     */
    private String overview;

    /**
     * The poster image path.
     * Append this to the TMDB image base URL to get the full image.
     * 海报图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The type of media, either "movie" or "tv".
     * 媒体类型，可以是 "movie" 或 "tv"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The original language, using ISO 639-1 two-letter code.
     * 原始语言，使用 ISO 639-1 两字母代码。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * List of genre IDs associated with the item.
     * 内容所属的类型 ID 列表。
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * The popularity score.
     * 热度指数。
     */
    private double popularity;

    /**
     * The release date (for movies) or first air date (for TV shows), formatted as YYYY-MM-DD.
     * 上映日期（电影）或首播日期（电视剧），格式为 YYYY-MM-DD。
     */
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * Indicates whether the item has a video (e.g., trailer).
     * 表示是否包含视频（例如预告片）。
     */
    private boolean video;

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
