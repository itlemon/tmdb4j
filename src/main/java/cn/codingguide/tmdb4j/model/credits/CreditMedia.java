package cn.codingguide.tmdb4j.model.credits;

import java.util.List;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a media item (movie or TV show) in the credit response.
 * Contains fields common to both, with additional TV-specific fields.
 * <p>
 * 表示演职员响应中的媒体项（电影或电视剧）。
 * 包含共有的字段，以及电视剧特有的字段。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CreditMedia {

    /**
     * Indicates whether the media is considered adult content.
     * 表示该媒体是否属于成人内容。
     */
    private boolean adult;

    /**
     * The backdrop image path. Append to TMDB base URL to get full image.
     * 背景图片路径。附加到 TMDB 基础 URL 以获取完整图片。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The unique identifier of the media.
     * 媒体的唯一标识符。
     */
    private int id;

    /**
     * The name of the TV show (for TV). May be null for movies.
     * 电视剧的名称（适用于电视剧）。对于电影可能为 null。
     */
    private String name;

    /**
     * The original name of the TV show (for TV). May be null for movies.
     * 电视剧的原始名称（适用于电视剧）。对于电影可能为 null。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The title of the movie (for movies). May be null for TV shows.
     * 电影的标题（适用于电影）。对于电视剧可能为 null。
     */
    private String title;

    /**
     * The original title of the movie (for movies). May be null for TV shows.
     * 电影的原始标题（适用于电影）。对于电视剧可能为 null。
     */
    @SerializedName("original_title")
    private String originalTitle;

    /**
     * The overview/description of the media.
     * 媒体的概述/描述。
     */
    private String overview;

    /**
     * The poster image path. Append to TMDB base URL to get full image.
     * 海报图片路径。附加到 TMDB 基础 URL 以获取完整图片。
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
     * The original language code (ISO 639-1) of the media.
     * 媒体的原始语言代码（ISO 639-1）。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * List of genre IDs associated with the media.
     * 媒体所属的类型 ID 列表。
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * The popularity score of the media.
     * 媒体的热度指数。
     */
    private double popularity;

    /**
     * The first air date of the TV show (format: YYYY-MM-DD). May be null for movies.
     * 电视剧的首播日期（格式：YYYY-MM-DD）。对于电影可能为 null。
     */
    @SerializedName("first_air_date")
    private String firstAirDate;

    /**
     * The release date of the movie (format: YYYY-MM-DD). May be null for TV shows.
     * 电影的上映日期（格式：YYYY-MM-DD）。对于电视剧可能为 null。
     */
    @SerializedName("release_date")
    private String releaseDate;

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

    /**
     * The origin country codes (ISO 3166-1) for TV shows. May be null for movies.
     * 电视剧的原始国家/地区代码列表（ISO 3166-1）。对于电影可能为 null。
     */
    @SerializedName("origin_country")
    private List<String> originCountry;

    /**
     * The character name played by the actor (for cast credits). May be null for crew.
     * 演员扮演的角色名称（对于演员信用）。对于工作人员可能为 null。
     */
    private String character;

    /**
     * List of episodes for the TV show (for cast credits on a TV show).
     * 电视剧的剧集列表（对于电视剧的演员信用）。
     */
    private List<CreditEpisode> episodes;

    /**
     * List of seasons for the TV show (for cast credits on a TV show).
     * 电视剧的季列表（对于电视剧的演员信用）。
     */
    private List<CreditSeason> seasons;

}
