package cn.codingguide.tmdb4j.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A country where the movie was produced.
 * <p>
 * 制作电影的国家/地区。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class ProductionCountry {

    /**
     * The ISO 3166-1 country code.
     * ISO 3166-1 国家代码。
     */
    @SerializedName("iso_3166_1")
    private String countryCode;

    /**
     * The name of the country.
     * 国家的名称。
     */
    private String name;

}
