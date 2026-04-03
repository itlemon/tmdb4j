package cn.codingguide.tmdb4j.model.configuration;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a country/region and its associated time zones.
 * Used in the configuration/timezones API response.
 * <p>
 * 表示一个国家/地区及其关联的时区列表。
 * 用于 configuration/timezones API 的响应。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class TimezoneEntry {

    /**
     * The ISO 3166-1 country code (e.g., "AD", "AE").
     * ISO 3166-1 国家代码（例如 "AD", "AE"）。
     */
    @SerializedName("iso_3166_1")
    private String countryCode;

    /**
     * The list of IANA time zone names for this country (e.g., "Europe/Andorra", "Asia/Dubai").
     * 该国家/地区的 IANA 时区名称列表（例如 "Europe/Andorra", "Asia/Dubai"）。
     */
    private List<String> zones;

}
