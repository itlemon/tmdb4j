package cn.codingguide.tmdb4j.model.tvs;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a TV series entity from TMDB.
 * Contains basic information such as name, overview, first air date, ratings, and images.
 * <p>
 * 表示 TMDB 中的电视剧实体。
 * 包含基本信息，如名称、概述、首播日期、评分和图片。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class TvSeries {

    /**
     * The unique identifier of the TV series.
     * 电视剧的唯一标识符。
     */
    private int id;

    /**
     * The localized name of the TV series.
     * 电视剧的本地化名称。
     */
    private String name;

    /**
     * The original name of the TV series in its original language.
     * 电视剧的原始名称（原始语言）。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The plot overview / description of the TV series.
     * 电视剧的剧情简介/描述。
     */
    private String overview;

    /**
     * The poster image path of the TV series.
     * Append this to the TMDB image base URL to get the full image.
     * 电视剧的海报图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The backdrop (background) image path of the TV series.
     * Append this to the TMDB image base URL to get the full image.
     * 电视剧的背景图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The first air date of the TV series, formatted as YYYY-MM-DD.
     * 电视剧的首播日期，格式为 YYYY-MM-DD。
     */
    @SerializedName("first_air_date")
    private String firstAirDate;

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
     * Indicates whether the TV series is considered adult content.
     * 表示该电视剧是否属于成人内容。
     */
    private boolean adult;

    /**
     * The popularity score of the TV series (higher is more popular).
     * 电视剧的热度指数（越高越受欢迎）。
     */
    private double popularity;

    /**
     * List of genre IDs associated with the TV series.
     * Use the genre API to map IDs to genre names.
     * 电视剧所属的类型 ID 列表。可通过调用 GET /3/genre/tv/list 接口获取 ID 对应的具体类型名称
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * The original language of the TV series, using ISO 639-1 two-letter code (e.g., "en").
     * 电视剧的原始语言，使用 ISO 639-1 两字母代码（例如 "en"）。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * The origin country codes (ISO 3166-1) of the TV series.
     * 电视剧的原始国家/地区代码列表（ISO 3166-1）。
     */
    @SerializedName("origin_country")
    private List<String> originCountry;

}
