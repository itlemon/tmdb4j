package cn.codingguide.tmdb4j.model.movies;

import cn.codingguide.tmdb4j.model.genres.Genre;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * Detailed information of a movie, including metadata, collection, genres, companies, etc.
 * <p>
 * 电影的详细信息，包含元数据、合集、类型、公司等。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class MovieDetails {

    /**
     * Indicates whether the movie is adult content.
     * 表示是否成人内容。
     */
    private boolean adult;

    /**
     * The backdrop image path.
     * 背景图片路径。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The collection (e.g., trilogy) this movie belongs to.
     * 该电影所属的合集（例如三部曲）。
     */
    @SerializedName("belongs_to_collection")
    private Collection belongsToCollection;

    /**
     * The budget of the movie in USD.
     * 电影的预算（美元）。
     */
    private long budget;

    /**
     * List of genres.
     * 类型列表。
     */
    private List<Genre> genres;

    /**
     * The official homepage URL.
     * 官方网站 URL。
     */
    private String homepage;

    /**
     * The unique identifier.
     * 唯一标识符。
     */
    private int id;

    /**
     * The IMDb ID (e.g., "tt1757678").
     * IMDb ID（例如 "tt1757678"）。
     */
    @SerializedName("imdb_id")
    private String imdbId;

    /**
     * The origin country codes (ISO 3166-1).
     * 原始国家/地区代码列表（ISO 3166-1）。
     */
    @SerializedName("origin_country")
    private List<String> originCountry;

    /**
     * The original language code (ISO 639-1).
     * 原始语言代码（ISO 639-1）。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * The original title.
     * 原始标题。
     */
    @SerializedName("original_title")
    private String originalTitle;

    /**
     * The overview/description.
     * 概述/描述。
     */
    private String overview;

    /**
     * The popularity score.
     * 热度指数。
     */
    private double popularity;

    /**
     * The poster image path.
     * 海报图片路径。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * List of production companies.
     * 制作公司列表。
     */
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;

    /**
     * List of production countries.
     * 制作国家/地区列表。
     */
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;

    /**
     * The release date (YYYY-MM-DD).
     * 上映日期（YYYY-MM-DD）。
     */
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * The revenue in USD.
     * 票房收入（美元）。
     */
    private long revenue;

    /**
     * The runtime in minutes.
     * 时长（分钟）。
     */
    private int runtime;

    /**
     * List of spoken languages.
     * 口语语言列表。
     */
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;

    /**
     * The release status (e.g., "Released", "Post Production").
     * 上映状态（例如 "Released", "Post Production"）。
     */
    private String status;

    /**
     * The tagline of the movie.
     * 电影的宣传语。
     */
    private String tagline;

    /**
     * The title of the movie.
     * 电影的标题。
     */
    private String title;

    /**
     * Indicates whether the movie has a video (e.g., trailer).
     * 表示是否有视频（如预告片）。
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
