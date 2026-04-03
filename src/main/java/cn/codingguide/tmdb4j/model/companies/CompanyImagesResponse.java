package cn.codingguide.tmdb4j.model.companies;

import java.util.List;

import cn.codingguide.tmdb4j.model.images.ImageInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the company images API.
 * Contains a list of logo images for the company.
 * <p>
 * 表示公司图片 API 的响应。
 * 包含公司的标志图片列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CompanyImagesResponse {

    /**
     * The unique identifier of the company.
     * 公司的唯一标识符。
     */
    private int id;

    /**
     * List of logo images associated with the company.
     * 与公司关联的标志图片列表。
     */
    private List<ImageInfo> logos;

}
