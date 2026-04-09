package cn.codingguide.tmdb4j.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A production company involved in making the movie.
 * <p>
 * 参与电影制作的制作公司。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class ProductionCompany {

    /**
     * The unique identifier of the company.
     * 公司的唯一标识符。
     */
    private int id;

    /**
     * The logo image path of the company.
     * 公司的标志图片路径。
     */
    @SerializedName("logo_path")
    private String logoPath;

    /**
     * The name of the company.
     * 公司的名称。
     */
    private String name;

    /**
     * The origin country code (ISO 3166-1) of the company.
     * 公司的原始国家代码（ISO 3166-1）。
     */
    @SerializedName("origin_country")
    private String originCountry;


}
