package cn.codingguide.tmdb4j.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 电影详情
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Getter
@Setter
@ToString
public class Movie {

    /**
     * 电影的唯一标识符，可用于调用其他需要电影 ID 的 API 接口
     */
    private int id;

    /**
     * 电影在指定语言环境下的本地化标题
     */
    private String title;

    /**
     * 电影的情节简介
     */
    private String overview;

    /**
     * 电影海报图片的路径。同样需要与图片基础 URL 拼接以获取完整图片
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * 电影背景图片（海报）的路径。获取完整图片 URL 需与 TMDB 的图片基础 URL 拼接
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * 电影的原始上映日期，格式为 YYYY-MM-DD
     */
    @SerializedName("release_date")
    private String releaseDate;

    /**
     * 所有用户评分的平均值，满分是10分
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * 为该电影投票的总用户人数
     */
    @SerializedName("vote_count")
    private int voteCount;

    /**
     * 表示该电影是否属于成人内容
     */
    private boolean adult;

    /**
     * 表示该电影条目是否包含预告片等视频内容
     */
    private boolean video;

    /**
     * 一个数值型的热度指数，数值越高代表电影在TMDB上越受欢迎
     */
    private double popularity;

    /**
     * 一个包含电影所属类型ID的数组。你可以通过调用 GET /3/genre/movie/list 接口来获取 ID 对应的具体类型名称
     */
    @SerializedName("genre_ids")
    private List<Integer> genreIds;

    /**
     * 电影的原始语言，使用 ISO 639-1 标准的两字母语言代码表示，例如 en 表示英语
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * 电影在其原始发行地区的原始标题
     */
    @SerializedName("original_title")
    private String originalTitle;

}
