package cn.codingguide.tmdb4j.model.configuration;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the TMDB configuration API.
 * Contains global configuration data such as image base URLs, change keys, countries, and languages.
 * <p>
 * 表示 TMDB 配置 API 的响应。
 * 包含全局配置数据，如图片基础 URL、变更密钥、国家/地区列表和语言列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class ConfigurationResponse {

    /**
     * List of change keys used to track changes in movies, TV shows, persons, etc.
     * 用于跟踪电影、电视剧、人员等变更的变更密钥列表。
     */
    @SerializedName("change_keys")
    private List<String> changeKeys;

    /**
     * Image configuration details (base URL, secure base URL, poster sizes, backdrop sizes, etc.).
     * 图片配置详情（基础 URL、安全基础 URL、海报尺寸、背景图尺寸等）。
     */
    private ImageConfiguration images;

}
