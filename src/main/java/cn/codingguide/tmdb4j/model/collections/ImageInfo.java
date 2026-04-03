package cn.codingguide.tmdb4j.model.collections;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a single image (backdrop, poster, etc.) associated with a collection or other entity.
 * Contains image metadata including dimensions, language, file path, and vote statistics.
 * <p>
 * 表示与合集或其他实体关联的单张图片（背景图、海报等）。
 * 包含图片的元数据，包括尺寸、语言、文件路径和投票统计信息。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class ImageInfo {

    /**
     * The aspect ratio of the image (width / height).
     * 图片的宽高比（宽度/高度）。
     */
    @SerializedName("aspect_ratio")
    private double aspectRatio;

    /**
     * The height of the image in pixels.
     * 图片的高度（像素）。
     */
    private int height;

    /**
     * The language of the image content (e.g., "en" for English, "pt" for Portuguese).
     * May be null for language-neutral images (e.g., backdrops).
     * 图片内容的语言（例如 "en" 表示英语，"pt" 表示葡萄牙语）。
     * 对于无语言偏好的图片（例如背景图）可能为 null。
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * The relative file path of the image.
     * Append this to the TMDB image base URL to get the full image.
     * 图片的相对文件路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("file_path")
    private String filePath;

    /**
     * The average vote score (0-10) for this image.
     * 该图片的平均投票得分（0-10 分）。
     */
    @SerializedName("vote_average")
    private double voteAverage;

    /**
     * The number of votes cast for this image.
     * 该图片的投票数量。
     */
    @SerializedName("vote_count")
    private int voteCount;

    /**
     * The width of the image in pixels.
     * 图片的宽度（像素）。
     */
    private int width;


}
