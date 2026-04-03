package cn.codingguide.tmdb4j.model.configuration;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a country supported by TMDB.
 * Contains the ISO 3166-1 country code, English name, and native name.
 * <p>
 * 表示 TMDB 支持的国家/地区。
 * 包含 ISO 3166-1 国家代码、英文名称和本土名称。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CountryInfo {

    /**
     * The ISO 3166-1 country code (e.g., "US", "CN").
     * ISO 3166-1 国家代码（例如 "US", "CN"）。
     */
    @SerializedName("iso_3166_1")
    private String countryCode;

    /**
     * The English name of the country (e.g., "United States", "China").
     * 国家的英文名称（例如 "United States", "China"）。
     */
    @SerializedName("english_name")
    private String englishName;

    /**
     * The native name of the country (e.g., "United States", "中国").
     * 国家的本土名称（例如 "United States", "中国"）。
     */
    @SerializedName("native_name")
    private String nativeName;


}
