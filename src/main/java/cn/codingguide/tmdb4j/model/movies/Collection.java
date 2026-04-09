package cn.codingguide.tmdb4j.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A movie collection (e.g., trilogy, series) containing multiple movies.
 * <p>
 * 电影合集（例如三部曲、系列），包含多部电影。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class Collection {

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
     * The poster image path of the collection.
     * 合集的海报图片路径。
     */
    @SerializedName("poster_path")
    private String posterPath;

    /**
     * The backdrop image path of the collection.
     * 合集的背景图片路径。
     */
    @SerializedName("backdrop_path")
    private String backdropPath;

}
