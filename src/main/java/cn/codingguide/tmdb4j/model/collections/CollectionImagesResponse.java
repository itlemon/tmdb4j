package cn.codingguide.tmdb4j.model.collections;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the collection images API.
 * Contains lists of backdrops and posters associated with the collection.
 * <p>
 * 表示合集图片 API 的响应。
 * 包含与合集相关的背景图和海报列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CollectionImagesResponse {

    /**
     * The unique identifier of the collection.
     * 合集的唯一标识符。
     */
    private int id;

    /**
     * List of backdrop images (usually landscape orientation).
     * 背景图列表（通常为横向）。
     */
    private List<ImageInfo> backdrops;

    /**
     * List of poster images (usually portrait orientation).
     * 海报列表（通常为竖向）。
     */
    private List<ImageInfo> posters;

}
