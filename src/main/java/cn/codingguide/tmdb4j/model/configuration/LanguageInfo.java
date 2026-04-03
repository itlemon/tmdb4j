package cn.codingguide.tmdb4j.model.configuration;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a language supported by TMDB.
 * Contains the ISO 639-1 language code, English name, and native name.
 * <p>
 * 表示 TMDB 支持的语言。
 * 包含 ISO 639-1 语言代码、英文名称和本土名称。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class LanguageInfo {

    /**
     * The ISO 639-1 language code (e.g., "en", "zh").
     * ISO 639-1 语言代码（例如 "en", "zh"）。
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * The English name of the language (e.g., "English", "Chinese").
     * 语言的英文名称（例如 "English", "Chinese"）。
     */
    @SerializedName("english_name")
    private String englishName;

    /**
     * The native name of the language (e.g., "English", "中文").
     * Maybe an empty string if not available.
     * 语言的本土名称（例如 "English", "中文"）。
     * 如果不可用，可能为空字符串。
     */
    @SerializedName("name")
    private String nativeName;

}
