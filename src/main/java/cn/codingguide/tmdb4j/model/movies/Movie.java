package cn.codingguide.tmdb4j.model.movies;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a movie entity from TMDB.
 * Contains basic information such as title, overview, release date, ratings, and images.
 * <p>
 * 表示 TMDB 中的电影实体。
 * 包含基本信息，如标题、概述、上映日期、评分和图片。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Getter
@Setter
@ToString
public class Movie {

    /**
     * The unique identifier of the movie.
     * 电影的唯一标识符。
     */
    private int id;

    /**
     * The localized title of the movie.
     * 电影的本地化标题。
     */
    private String title;

    /**
     * The original title of the movie in its original language.
     * 电影的原始标题（原始语言）。
     */
    @SerializedName("original_title")
    private String originalTitle;

    /**
     * The plot overview / description of the movie.
     * 电影的剧情简介/描述。
     */
    private String overview;

    /**
     * The release date of the movie, formatted as YYYY-MM-DD.
     * 电影的上映日期，格式为 YYYY-MM-DD。
     */
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * The poster image path of the movie.
     * Append this to the TMDB image base URL to get the full image.
     * 电影的海报图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The backdrop (background) image path of the movie.
     * Append this to the TMDB image base URL to get the full image.
     * 电影的背景图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * Indicates whether the movie is considered adult content.
     * 表示该电影是否属于成人内容。
     */
    private boolean adult;

    /**
     * Indicates whether the movie has a video (e.g., trailer) associated.
     * 表示该电影是否关联了视频（例如预告片）。
     */
    private boolean video;

    /**
     * The popularity score of the movie (higher is more popular).
     * 电影的热度指数（越高越受欢迎）。
     */
    private double popularity;

    /**
     * The average vote score (0-10) from all users.
     * 所有用户评分的平均值（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The total number of votes received.
     * 收到的投票总数。
     */
    @SerializedName("vote_count")
    private int voteCount;

    /**
     * List of genre IDs associated with the movie.
     * Use the genre API to map IDs to genre names.
     * 电影所属的类型 ID 列表。可通过类型 API 将 ID 映射为类型名称。
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * The original language of the movie, using ISO 639-1 two-letter code (e.g., "en").
     * 电影的原始语言，使用 ISO 639-1 两字母代码（例如 "en"）。
     */
    @SerializedName("original_language")
    private String originalLanguage;

}
