package cn.codingguide.tmdb4j.model.discover;

import java.util.HashMap;
import java.util.Map;

import cn.codingguide.tmdb4j.constants.SortBy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Options for discovering TV series via the TMDB discover/tv endpoint.
 * Supports all official parameters including filters, sorting, pagination, and advanced criteria.
 * <p>
 * 通过 TMDB discover/tv 端点发现电视剧的筛选选项。
 * 支持所有官方参数，包括过滤器、排序、分页及高级条件。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@Builder
@ToString
public class TvDiscoverOptions {

    // ==================== 播出日期 (Air Date) ====================
    /**
     * Minimum air date (format: YYYY-MM-DD).
     * 最小播出日期（格式：YYYY-MM-DD）。
     */
    private String airDateGte;

    /**
     * Maximum air date (format: YYYY-MM-DD).
     * 最大播出日期（格式：YYYY-MM-DD）。
     */
    private String airDateLte;

    // ==================== 首播日期 (First Air Date) ====================
    /**
     * Exact first air year (format: YYYY).
     * 精确的首播年份（格式：YYYY）。
     */
    private String firstAirDateYear;

    /**
     * Minimum first air date (format: YYYY-MM-DD).
     * 最小首播日期（格式：YYYY-MM-DD）。
     */
    private String firstAirDateGte;

    /**
     * Maximum first air date (format: YYYY-MM-DD).
     * 最大首播日期（格式：YYYY-MM-DD）。
     */
    private String firstAirDateLte;

    // ==================== 基础筛选 (Basic Filters) ====================
    /**
     * Include adult content (true/false). Default false.
     * 是否包含成人内容（true/false）。默认 false。
     */
    private Boolean includeAdult;

    /**
     * Include TV series that have no first air date (true/false).
     * 是否包含没有首播日期的电视剧（true/false）。
     */
    private Boolean includeNullFirstAirDates;

    // ==================== 语言与分页 (Language & Pagination) ====================
    /**
     * ISO 639-1 language code to localize the results (e.g., "en-US", "zh-CN").
     * ISO 639-1 语言代码，用于本地化结果（例如 "en-US", "zh-CN"）。
     */
    private String language;

    /**
     * Page number to fetch. Minimum 1. Default 1.
     * 要获取的页码。最小值为 1。默认为 1。
     */
    private Integer page;

    // ==================== 特殊筛选 (Special Filters) ====================
    /**
     * Filter by whether the TV series has been screened theatrically (true/false).
     * 按是否在影院放映过筛选（true/false）。
     */
    private Boolean screenedTheatrically;

    /**
     * Sort order of the results.
     * Possible values: "popularity.asc", "popularity.desc", "first_air_date.asc", "first_air_date.desc",
     * "vote_average.asc", "vote_average.desc", "vote_count.asc", "vote_count.desc". Default is "popularity.desc".
     * <p>
     * 结果的排序方式。
     * 可选值："popularity.asc", "popularity.desc", "first_air_date.asc", "first_air_date.desc",
     * "vote_average.asc", "vote_average.desc", "vote_count.asc", "vote_count.desc"。默认为 "popularity.desc"。
     */
    private SortBy sortBy;

    /**
     * IANA time zone (e.g., "America/New_York") for date-based filters.
     * 用于日期筛选的 IANA 时区（例如 "America/New_York"）。
     */
    private String timezone;

    // ==================== 评分与投票 (Ratings & Votes) ====================
    /**
     * Minimum vote average (inclusive). E.g., 7.0.
     * 最低平均评分（包含）。例如 7.0。
     */
    private Double voteAverageGte;

    /**
     * Maximum vote average (inclusive). E.g., 10.0.
     * 最高平均评分（包含）。例如 10.0。
     */
    private Double voteAverageLte;

    /**
     * Minimum number of votes (inclusive).
     * 最低投票数量（包含）。
     */
    private Integer voteCountGte;

    /**
     * Maximum number of votes (inclusive).
     * 最高投票数量（包含）。
     */
    private Integer voteCountLte;

    // ==================== 观看地区与提供商 (Watch Region & Providers) ====================
    /**
     * ISO 3166-1 country code for watch provider filters. Default is "US".
     * 用于观看提供商筛选的 ISO 3166-1 国家/地区代码。默认为 "US"。
     */
    private String watchRegion;

    /**
     * Comma-separated list of watch provider IDs to include.
     * 要包含的观看提供商 ID 列表，多个用逗号分隔。
     */
    private String withWatchProviders;

    /**
     * Comma-separated list of watch provider IDs to exclude.
     * 要排除的观看提供商 ID 列表，多个用逗号分隔。
     */
    private String withoutWatchProviders;

    /**
     * Filter by watch monetization types. Comma-separated values.
     * Possible values: "flatrate", "free", "ads", "rent", "buy".
     * 按观看变现类型筛选。逗号分隔的值。
     * 可选值："flatrate"（订阅）、"free"（免费）、"ads"（带广告）、"rent"（租赁）、"buy"（购买）。
     */
    private String withWatchMonetizationTypes;

    // ==================== 公司 (Companies) ====================
    /**
     * Comma-separated list of production company IDs to include.
     * 要包含的制作公司 ID 列表，多个用逗号分隔。
     */
    private String withCompanies;

    /**
     * Comma-separated list of production company IDs to exclude.
     * 要排除的制作公司 ID 列表，多个用逗号分隔。
     */
    private String withoutCompanies;

    // ==================== 类型 (Genres) ====================
    /**
     * Comma-separated list of genre IDs to include.
     * 要包含的类型 ID 列表，多个用逗号分隔。
     */
    private String withGenres;

    /**
     * Comma-separated list of genre IDs to exclude.
     * 要排除的类型 ID 列表，多个用逗号分隔。
     */
    private String withoutGenres;

    // ==================== 关键词 (Keywords) ====================
    /**
     * Comma-separated list of keyword IDs to include.
     * 要包含的关键词 ID 列表，多个用逗号分隔。
     */
    private String withKeywords;

    /**
     * Comma-separated list of keyword IDs to exclude.
     * 要排除的关键词 ID 列表，多个用逗号分隔。
     */
    private String withoutKeywords;

    // ==================== 网络、国家、语言 (Networks, Countries, Languages) ====================
    /**
     * Comma-separated list of network IDs to include.
     * 要包含的网络 ID 列表，多个用逗号分隔。
     */
    private String withNetworks;

    /**
     * Comma-separated list of origin country codes (ISO 3166-1).
     * 原始国家/地区代码列表（ISO 3166-1），多个用逗号分隔。
     */
    private String withOriginCountry;

    /**
     * Comma-separated list of original language codes (ISO 639-1).
     * 原始语言代码列表（ISO 639-1），多个用逗号分隔。
     */
    private String withOriginalLanguage;

    // ==================== 时长与状态 (Runtime & Status) ====================
    /**
     * Minimum runtime in minutes (inclusive).
     * 最低时长（分钟，包含）。
     */
    private Integer withRuntimeGte;

    /**
     * Maximum runtime in minutes (inclusive).
     * 最高时长（分钟，包含）。
     */
    private Integer withRuntimeLte;

    /**
     * possible values are: [0, 1, 2, 3, 4, 5], can be a comma (AND) or pipe (OR) separated query
     * Filter by TV series status. Uses the TvStatus enum.
     * 按电视剧状态筛选。使用 TvStatus 枚举。
     */
    private String withStatus;

    /**
     * possible values are: [0, 1, 2, 3, 4, 5, 6], can be a comma (AND) or pipe (OR) separated query
     * Filter by TV series type. Uses the TvType enum.
     * 按电视剧类型筛选。使用 TvType 枚举。
     */
    private String withType;

    // ==================== 转换方法 ====================

    /**
     * Converts the options to a map suitable for Retrofit's @QueryMap.
     * Only non-null values are added.
     * <p>
     * 将选项转换为适用于 Retrofit 的 @QueryMap 的映射。
     * 仅添加非 null 的值。
     *
     * @return A map of query parameters.
     * 查询参数映射。
     */
    public Map<String, String> toQueryMap() {
        Map<String, String> map = new HashMap<>();

        // 播出日期
        if (airDateGte != null) {
            map.put("air_date.gte", airDateGte);
        }
        if (airDateLte != null) {
            map.put("air_date.lte", airDateLte);
        }

        // 首播日期
        if (firstAirDateYear != null) {
            map.put("first_air_date_year", firstAirDateYear);
        }
        if (firstAirDateGte != null) {
            map.put("first_air_date.gte", firstAirDateGte);
        }
        if (firstAirDateLte != null) {
            map.put("first_air_date.lte", firstAirDateLte);
        }

        // 基础筛选
        if (includeAdult != null) {
            map.put("include_adult", includeAdult.toString());
        }
        if (includeNullFirstAirDates != null) {
            map.put("include_null_first_air_dates", includeNullFirstAirDates.toString());
        }

        // 语言与分页
        if (language != null) {
            map.put("language", language);
        }
        if (page != null) {
            map.put("page", page.toString());
        }

        // 特殊筛选
        if (screenedTheatrically != null) {
            map.put("screened_theatrically", screenedTheatrically.toString());
        }
        if (sortBy != null) {
            map.put("sort_by", sortBy.getValue());
        }
        if (timezone != null) {
            map.put("timezone", timezone);
        }

        // 评分与投票
        if (voteAverageGte != null) {
            map.put("vote_average.gte", voteAverageGte.toString());
        }
        if (voteAverageLte != null) {
            map.put("vote_average.lte", voteAverageLte.toString());
        }
        if (voteCountGte != null) {
            map.put("vote_count.gte", voteCountGte.toString());
        }
        if (voteCountLte != null) {
            map.put("vote_count.lte", voteCountLte.toString());
        }

        // 观看相关
        if (watchRegion != null) {
            map.put("watch_region", watchRegion);
        }
        if (withWatchProviders != null) {
            map.put("with_watch_providers", withWatchProviders);
        }
        if (withoutWatchProviders != null) {
            map.put("without_watch_providers", withoutWatchProviders);
        }
        if (withWatchMonetizationTypes != null) {
            map.put("with_watch_monetization_types", withWatchMonetizationTypes);
        }

        // 公司
        if (withCompanies != null) {
            map.put("with_companies", withCompanies);
        }
        if (withoutCompanies != null) {
            map.put("without_companies", withoutCompanies);
        }

        // 类型
        if (withGenres != null) {
            map.put("with_genres", withGenres);
        }
        if (withoutGenres != null) {
            map.put("without_genres", withoutGenres);
        }

        // 关键词
        if (withKeywords != null) {
            map.put("with_keywords", withKeywords);
        }
        if (withoutKeywords != null) {
            map.put("without_keywords", withoutKeywords);
        }

        // 网络、国家、语言
        if (withNetworks != null) {
            map.put("with_networks", withNetworks);
        }
        if (withOriginCountry != null) {
            map.put("with_origin_country", withOriginCountry);
        }
        if (withOriginalLanguage != null) {
            map.put("with_original_language", withOriginalLanguage);
        }

        // 时长与状态
        if (withRuntimeGte != null) {
            map.put("with_runtime.gte", withRuntimeGte.toString());
        }
        if (withRuntimeLte != null) {
            map.put("with_runtime.lte", withRuntimeLte.toString());
        }
        if (withStatus != null) {
            map.put("with_status", withStatus);
        }
        if (withType != null) {
            map.put("with_type", withType);
        }

        return map;
    }

}
