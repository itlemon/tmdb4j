package cn.codingguide.tmdb4j.model.collections;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a movie collection (e.g., "Star Wars Collection").
 * Contains collection metadata and a list of movies/TV shows belonging to it.
 * <p>
 * 表示一个电影合集（例如“星球大战合集”）。
 * 包含合集的元数据以及属于该合集的电影或电视剧列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CollectionDetails {

    /**
     * The unique identifier of the collection.
     * 合集的唯一标识符。
     */
    private int id;

    /**
     * The name of the collection.
     * 合集的名称。
     */
    private String name;

    /**
     * The original language of the collection, using ISO 639-1 two-letter code.
     * 合集的原始语言，使用 ISO 639-1 两字母代码。
     */
    @SerializedName("original_language")
    private String originalLanguage;

    /**
     * The original name of the collection (usually same as name).
     * 合集的原始名称（通常与 name 相同）。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The overview/description of the collection.
     * 合集的概述/描述。
     */
    private String overview;

    /**
     * The poster image path of the collection.
     * Append this to the TMDB image base URL to get the full image.
     * 合集的海报图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The backdrop image path of the collection.
     * Append this to the TMDB image base URL to get the full image.
     * 合集的背景图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

    /**
     * The list of media items (movies or TV shows) that belong to this collection.
     * 属于该合集的媒体项目（电影或电视剧）列表。
     */
    private List<CollectionPart> parts;

}
