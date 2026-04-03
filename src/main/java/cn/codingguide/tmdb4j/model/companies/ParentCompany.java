package cn.codingguide.tmdb4j.model.companies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the parent company of a production company.
 * Contains basic information about the parent company.
 * <p>
 * 表示制作公司的母公司。
 * 包含母公司的基本信息。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class ParentCompany {

    /**
     * The unique identifier of the parent company.
     * 母公司的唯一标识符。
     */
    private int id;

    /**
     * The name of the parent company.
     * 母公司的名称。
     */
    private String name;

    /**
     * The relative path to the parent company's logo image.
     * Append this to the TMDB image base URL to get the full image.
     * 母公司标志图片的相对路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("logo_path")
    private String logoPath;

    /**
     * The country code of the parent company's origin (ISO 3166-1).
     * 母公司所在国家/地区的代码（ISO 3166-1）。
     */
    @SerializedName("origin_country")
    private String originCountry;

}
