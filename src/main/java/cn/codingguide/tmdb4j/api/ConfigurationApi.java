package cn.codingguide.tmdb4j.api;

import java.util.List;

import cn.codingguide.tmdb4j.model.configuration.ConfigurationResponse;
import cn.codingguide.tmdb4j.model.configuration.CountryInfo;
import cn.codingguide.tmdb4j.model.configuration.JobDepartment;
import cn.codingguide.tmdb4j.model.configuration.LanguageInfo;
import cn.codingguide.tmdb4j.model.configuration.TimezoneEntry;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
public interface ConfigurationApi {

    /**
     * Get the API configuration information.
     * This includes image base URLs, available size options, and change keys.
     * <p>
     * 获取 API 配置信息。
     * 包括图片基础 URL、可用尺寸选项以及变更密钥。
     *
     * @return ConfigurationResponse containing global configuration data.
     * 包含全局配置数据的 ConfigurationResponse 对象。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-details">API LINK</a>
     */
    @GET("configuration")
    Call<ConfigurationResponse> getConfigurationDetails();

    /**
     * Get the list of countries supported by TMDB.
     * The response is an array of country objects containing ISO 3166-1 codes, English names, and native names.
     * <p>
     * 获取 TMDB 支持的国家/地区列表。
     * 响应是一个国家对象数组，包含 ISO 3166-1 代码、英文名称和本土名称。
     *
     * @return A list of CountryInfo objects.
     * CountryInfo 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-countries">API LINK</a>
     */
    @GET("configuration/countries")
    Call<List<CountryInfo>> getCountries();

    /**
     * Get the list of languages supported by TMDB.
     * The response is an array of language objects containing ISO 639-1 codes, English names, and native names.
     * <p>
     * 获取 TMDB 支持的语言列表。
     * 响应是一个语言对象数组，包含 ISO 639-1 代码、英文名称和本土名称。
     *
     * @return A list of LanguageInfo objects.
     * LanguageInfo 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-languages">API LINK</a>
     */
    @GET("configuration/languages")
    Call<List<LanguageInfo>> getLanguages();


    /**
     * Get the list of departments and their associated jobs.
     * The response is an array of JobDepartment objects.
     * <p>
     * 获取部门及其关联的工作岗位列表。
     * 响应是一个 JobDepartment 对象数组。
     *
     * @return A list of JobDepartment objects.
     * JobDepartment 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-jobs">API LINK</a>
     */
    @GET("configuration/jobs")
    Call<List<JobDepartment>> getJobs();

    /**
     * Get the list of primary translation language codes supported by TMDB.
     * The response is an array of language codes with optional region suffix (e.g., "en-US", "zh-CN").
     * <p>
     * 获取 TMDB 支持的主要翻译语言代码列表。
     * 响应是一个语言代码数组，可能包含地区后缀（例如 "en-US", "zh-CN"）。
     *
     * @return A list of language code strings (e.g., "af-ZA", "ar-AE").
     * 语言代码字符串列表（例如 "af-ZA", "ar-AE"）。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-primary-translations">API LINK</a>
     */
    @GET("configuration/primary_translations")
    Call<List<String>> getPrimaryTranslations();

    /**
     * Get the list of time zones supported by TMDB.
     * The response is an array of TimezoneEntry objects, each containing a country code and its time zones.
     * <p>
     * 获取 TMDB 支持的时区列表。
     * 响应是一个 TimezoneEntry 对象数组，每个对象包含国家代码及其时区列表。
     *
     * @return A list of TimezoneEntry objects.
     * TimezoneEntry 对象的列表。
     * @see <a href="https://developer.themoviedb.org/reference/configuration-timezones">API LINK</a>
     */
    @GET("configuration/timezones")
    Call<List<TimezoneEntry>> getTimezones();

}
