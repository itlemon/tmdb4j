package cn.codingguide.tmdb4j.model.collections;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a single translation entry for a collection.
 * Contains language metadata and the translated data (title, overview, homepage).
 * <p>
 * 表示合集的单个翻译条目。
 * 包含语言元数据以及翻译后的数据（标题、概述、主页）。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class TranslationInfo {

    /**
     * The country/region code (ISO 3166-1) for this translation.
     * 此翻译的国家/地区代码（ISO 3166-1）。
     */
    @SerializedName("iso_3166_1")
    private String countryCode;

    /**
     * The language code (ISO 639-1) for this translation.
     * 此翻译的语言代码（ISO 639-1）。
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * The name of the language in its native script (e.g., "العربية").
     * 该语言的本土名称（例如 "العربية"）。
     */
    private String name;

    /**
     * The English name of the language (e.g., "Arabic").
     * 该语言的英文名称（例如 "Arabic"）。
     */
    @SerializedName("english_name")
    private String englishName;

    /**
     * The translated data object containing title, overview, and homepage.
     * 包含标题、概述和主页的翻译数据对象。
     */
    private TranslationData data;

}
