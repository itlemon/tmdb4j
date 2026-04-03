package cn.codingguide.tmdb4j.model;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class CustomList {

    /**
     * 列表的描述信息
     */
    private String description;

    /**
     * 该列表被用户收藏的次数
     */
    @SerializedName("favorite_count")
    private int favoriteCount;

    /**
     * 列表的唯一标识符
     */
    private int id;

    /**
     * 列表中包含的项目数量（电影或电视剧）
     */
    @SerializedName("item_count")
    private int itemCount;

    /**
     * 列表的语言，使用 ISO 639-1 标准的两字母语言代码表示，例如 zh 表示中文
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * 列表的类型，可选值 "movie" 或 "tv"
     */
    @SerializedName("list_type")
    private MediaType listType;

    /**
     * 列表的名称
     */
    private String name;

    /**
     * 列表的海报图片路径，可能为 null
     */
    @SerializedName("poster_path")
    private String posterPath;

}
