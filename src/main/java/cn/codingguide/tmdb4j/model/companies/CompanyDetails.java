package cn.codingguide.tmdb4j.model.companies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the details of a production company.
 * Contains company metadata such as name, description, headquarters, homepage, and logo.
 * <p>
 * 表示制作公司的详细信息。
 * 包含公司元数据，如名称、描述、总部、主页和标志。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CompanyDetails {

    /**
     * The unique identifier of the company.
     * 公司的唯一标识符。
     */
    private int id;

    /**
     * The name of the company.
     * 公司的名称。
     */
    private String name;

    /**
     * The description of the company (may be null or empty).
     * 公司的描述（可能为 null 或空字符串）。
     */
    private String description;

    /**
     * The headquarters location of the company (e.g., "San Francisco, California").
     * 公司的总部所在地（例如 "San Francisco, California"）。
     */
    private String headquarters;

    /**
     * The official homepage URL of the company.
     * 公司的官方网站 URL。
     */
    private String homepage;

    /**
     * The relative path to the company's logo image.
     * Append this to the TMDB image base URL to get the full image.
     * 公司标志图片的相对路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("logo_path")
    private String logoPath;

    /**
     * The country code of the company's origin (ISO 3166-1).
     * 公司所在国家/地区的代码（ISO 3166-1）。
     */
    @SerializedName("origin_country")
    private String originCountry;

    /**
     * The parent company of this company (if any). May be null.
     * 该公司的母公司（如果有）。可能为 null。
     */
    @SerializedName("parent_company")
    private ParentCompany parentCompany;

}
