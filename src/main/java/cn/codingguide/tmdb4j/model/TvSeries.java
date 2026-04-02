package cn.codingguide.tmdb4j.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 电视剧详情
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class TvSeries {

    /**
     * 电视剧的唯一标识符，可用于调用其他需要电视剧 ID 的 API 接口
     */
    private int id;

    /**
     * 电视剧在指定语言环境下的本地化名称
     */
    private String name;

    /**
     * 电视剧的原始名称（通常为英文原名）
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * 电视剧的情节简介
     */
    private String overview;

    /**
     * 电视剧海报图片的路径。需要与 TMDB 图片基础 URL 拼接以获取完整图片
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * 电视剧背景图片（剧照）的路径。需要与 TMDB 图片基础 URL 拼接以获取完整图片
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * 电视剧的首播日期，格式为 YYYY-MM-DD
     */
    @SerializedName("first_air_date")
    private String firstAirDate;

    /**
     * 所有用户评分的平均值，满分10分
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * 为该电视剧投票的总用户人数
     */
    @SerializedName("vote_count")
    private int voteCount;

    /**
     * 表示该电视剧是否属于成人内容
     */
    private boolean adult;

    /**
     * 一个数值型的热度指数，数值越高代表电视剧在TMDB上越受欢迎
     */
    private double popularity;

    /**
     * 一个包含电视剧所属类型ID的数组。可通过调用 GET /3/genre/tv/list 接口获取 ID 对应的具体类型名称
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * 电视剧的原始语言，使用 ISO 639-1 标准的两字母语言代码表示，例如 en 表示英语
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * 电视剧的原始发行国家/地区，使用 ISO 3166-1 标准的两字母国家代码表示，例如 US 表示美国
     */
    @SerializedName("origin_country")
    private List<String> originCountry;

}
