package cn.codingguide.tmdb4j.model.discover;

import java.util.HashMap;
import java.util.Map;

import cn.codingguide.tmdb4j.constants.SortBy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Complete options for discovering movies via the TMDB discover/movie endpoint.
 * Supports all 38 official parameters including filters, sorting, pagination, and advanced criteria.
 * <p>
 * 通过 TMDB discover/movie 端点发现电影的完整筛选选项。
 * 支持所有 38 个官方参数，包括过滤器、排序、分页及高级条件。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@Builder
@ToString
public class MovieDiscoverOptions {

    // ==================== 认证 (Certification) ====================
    /**
     * Certification code to filter (e.g., "R", "PG-13").
     * Requires certification_country.
     * 用于筛选的认证代码（例如 "R", "PG-13"）。
     * 需要同时提供 certification_country。
     */
    private String certification;

    /**
     * Minimum certification rating (e.g., "R" means R or higher).
     * 最低认证等级（例如 "R" 表示 R 级或更高）。
     */
    private String certificationGte;

    /**
     * Maximum certification rating.
     * 最高认证等级。
     */
    private String certificationLte;

    /**
     * Country code for the certification filter (ISO 3166-1).
     * Required if certification is set.
     * 认证筛选的国家/地区代码（ISO 3166-1）。
     * 如果设置了 certification 则必须提供。
     */
    private String certificationCountry;

    // ==================== 成人内容与视频 ====================
    /**
     * Include adult movies (true/false). Default false.
     * 是否包含成人电影（true/false）。默认 false。
     */
    private Boolean includeAdult;

    /**
     * Include videos (true/false). Filter by whether the movie has a video/trailer.
     * 是否包含视频（true/false）。按是否有视频/预告片筛选。
     */
    private Boolean includeVideo;

    // ==================== 语言与分页 ====================
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

    // ==================== 上映日期 (Primary Release Date) ====================
    /**
     * Exact primary release year (YYYY).
     * 精确的主要上映年份（YYYY）。
     */
    private String primaryReleaseYear;

    /**
     * Minimum primary release date (YYYY-MM-DD).
     * 最小主要上映日期（YYYY-MM-DD）。
     */
    private String primaryReleaseDateGte;

    /**
     * Maximum primary release date (YYYY-MM-DD).
     * 最大主要上映日期（YYYY-MM-DD）。
     */
    private String primaryReleaseDateLte;

    // ==================== 地区与上映日期 (Region & Release Date) ====================
    /**
     * ISO 3166-1 country code to filter release dates. E.g., "US".
     * 用于筛选上映日期的 ISO 3166-1 国家/地区代码。例如 "US"。
     */
    private String region;

    /**
     * Minimum release date (YYYY-MM-DD).
     * 最小上映日期（YYYY-MM-DD）。
     */
    private String releaseDateGte;

    /**
     * Maximum release date (YYYY-MM-DD).
     * 最大上映日期（YYYY-MM-DD）。
     */
    private String releaseDateLte;

    // ==================== 排序 ====================
    /**
     * Sort order of the results.
     * Possible values: "popularity.asc", "popularity.desc", "release_date.asc", "release_date.desc",
     * "revenue.asc", "revenue.desc", "primary_release_date.asc", "primary_release_date.desc",
     * "original_title.asc", "original_title.desc", "vote_average.asc", "vote_average.desc",
     * "vote_count.asc", "vote_count.desc". Default is "popularity.desc".
     * <p>
     * 结果的排序方式。
     * 可选值： "popularity.asc", "popularity.desc", "release_date.asc", "release_date.desc",
     * "revenue.asc", "revenue.desc", "primary_release_date.asc", "primary_release_date.desc",
     * "original_title.asc", "original_title.desc", "vote_average.asc", "vote_average.desc",
     * "vote_count.asc", "vote_count.desc"。默认为 "popularity.desc"。
     */
    private SortBy sortBy;

    // ==================== 评分与投票 ====================
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

    // ==================== 人员 (Cast/Crew) ====================
    /**
     * Comma-separated list of person IDs (actors) to include.
     * 要包含的人员 ID（演员）列表，多个用逗号分隔。
     */
    private String withCast;

    /**
     * Comma-separated list of person IDs (crew) to include.
     * 要包含的人员 ID（剧组人员）列表，多个用逗号分隔。
     */
    private String withCrew;

    /**
     * Comma-separated list of person IDs (either cast or crew) to include.
     * 要包含的人员 ID（演员或剧组人员）列表，多个用逗号分隔。
     */
    private String withPeople;

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
     * Comma-separated list of genre IDs to include (e.g., "35,18" for comedy and drama).
     * 要包含的类型 ID 列表，多个用逗号分隔（例如 "35,18" 表示喜剧和剧情）。
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

    // ==================== 国家/地区 (Origin Country & Original Language) ====================
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

    // ==================== 发行类型 (Release Type) ====================
    /**
     * Filter by release type(s). Use pipe (|) to combine multiple types.
     * Possible values: 1 (Premiere), 2 (Theatrical limited), 3 (Theatrical), 4 (Digital),
     * 5 (Physical), 6 (TV). Example: "2|3" for limited or theatrical.
     * <p>
     * 按发行类型筛选。使用竖线（|）组合多个类型。
     * 可选值：1（首映）、2（有限上映）、3（院线上映）、4（数字发行）、
     * 5（实体发行）、6（电视播出）。例如 "2|3" 表示有限上映或院线上映。
     */
    private String withReleaseType;

    // ==================== 时长 (Runtime) ====================
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

    // ==================== 年份 (Year) ====================
    /**
     * Filter by year (YYYY). This is a shortcut for primary_release_year.
     * 按年份筛选（YYYY）。这是 primary_release_year 的快捷方式。
     */
    private String year;

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

        // 认证
        if (certification != null) {
            map.put("certification", certification);
        }
        if (certificationGte != null) {
            map.put("certification.gte", certificationGte);
        }
        if (certificationLte != null) {
            map.put("certification.lte", certificationLte);
        }
        if (certificationCountry != null) {
            map.put("certification_country", certificationCountry);
        }

        // 成人/视频
        if (includeAdult != null) {
            map.put("include_adult", includeAdult.toString());
        }
        if (includeVideo != null) {
            map.put("include_video", includeVideo.toString());
        }

        // 语言/分页
        if (language != null) {
            map.put("language", language);
        }
        if (page != null) {
            map.put("page", page.toString());
        }

        // 主要上映日期
        if (primaryReleaseYear != null) {
            map.put("primary_release_year", primaryReleaseYear);
        }
        if (primaryReleaseDateGte != null) {
            map.put("primary_release_date.gte", primaryReleaseDateGte);
        }
        if (primaryReleaseDateLte != null) {
            map.put("primary_release_date.lte", primaryReleaseDateLte);
        }

        // 地区/上映日期
        if (region != null) {
            map.put("region", region);
        }
        if (releaseDateGte != null) {
            map.put("release_date.gte", releaseDateGte);
        }
        if (releaseDateLte != null) {
            map.put("release_date.lte", releaseDateLte);
        }

        // 排序
        if (sortBy != null) {
            map.put("sort_by", sortBy.getValue());
        }

        // 评分/投票
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

        // 人员
        if (withCast != null) {
            map.put("with_cast", withCast);
        }
        if (withCrew != null) {
            map.put("with_crew", withCrew);
        }
        if (withPeople != null) {
            map.put("with_people", withPeople);
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

        // 国家/语言
        if (withOriginCountry != null) {
            map.put("with_origin_country", withOriginCountry);
        }
        if (withOriginalLanguage != null) {
            map.put("with_original_language", withOriginalLanguage);
        }

        // 发行类型
        if (withReleaseType != null) {
            map.put("with_release_type", withReleaseType);
        }

        // 时长
        if (withRuntimeGte != null) {
            map.put("with_runtime.gte", withRuntimeGte.toString());
        }
        if (withRuntimeLte != null) {
            map.put("with_runtime.lte", withRuntimeLte.toString());
        }

        // 年份
        if (year != null) {
            map.put("year", year);
        }

        return map;
    }
}
