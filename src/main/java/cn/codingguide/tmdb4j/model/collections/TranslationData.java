package cn.codingguide.tmdb4j.model.collections;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the translated content (title, overview, homepage) for a collection.
 * Some fields may be empty strings if not translated.
 * <p>
 * 表示合集的翻译内容（标题、概述、主页）。
 * 某些字段可能为空字符串（若未翻译）。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class TranslationData {

    /**
     * The translated title of the collection.
     * 合集的翻译标题。
     */
    private String title;

    /**
     * The translated overview/description of the collection.
     * 合集的翻译概述/描述。
     */
    private String overview;

    /**
     * The translated homepage URL of the collection (if available).
     * 合集的翻译主页 URL（如果可用）。
     */
    private String homepage;

}
