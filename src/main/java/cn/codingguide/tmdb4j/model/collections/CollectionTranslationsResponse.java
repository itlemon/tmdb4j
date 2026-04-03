package cn.codingguide.tmdb4j.model.collections;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the collection translations API.
 * Contains a list of available translations for the collection.
 * <p>
 * 表示合集翻译 API 的响应。
 * 包含合集的可用翻译列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CollectionTranslationsResponse {

    /**
     * The unique identifier of the collection.
     * 合集的唯一标识符。
     */
    private int id;

    /**
     * List of translations available for the collection.
     * 合集的可用翻译列表。
     */
    private List<TranslationInfo> translations;

}
