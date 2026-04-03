package cn.codingguide.tmdb4j.model.credits;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a person (actor or crew) in the credit response.
 * Contains basic person information such as name, gender, profile image, etc.
 * <p>
 * 表示演职员响应中的人员（演员或剧组人员）。
 * 包含人员基本信息，如姓名、性别、头像等。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CreditPerson {

    /**
     * Indicates whether the person is considered adult content.
     * 表示该人员是否属于成人内容。
     */
    private boolean adult;

    /**
     * The unique identifier of the person.
     * 人员的唯一标识符。
     */
    private int id;

    /**
     * The name of the person.
     * 人员的姓名。
     */
    private String name;

    /**
     * The original name of the person (may be same as name).
     * 人员的原始姓名（可能与 name 相同）。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The type of media, typically "person".
     * 媒体类型，通常为 "person"。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The popularity score of the person.
     * 人员的热度指数。
     */
    private double popularity;

    /**
     * The gender of the person (0 = not specified, 1 = female, 2 = male).
     * 人员的性别（0 = 未指定，1 = 女性，2 = 男性）。
     */
    private int gender;

    /**
     * The primary known department of the person (e.g., "Acting", "Directing").
     * 人员的主要知名部门（例如 "Acting", "Directing"）。
     */
    @SerializedName("known_for_department")
    private String knownForDepartment;

    /**
     * The profile image path of the person. Append to TMDB base URL to get full image.
     * 人员的头像图片路径。附加到 TMDB 基础 URL 以获取完整图片。
     */
    @SerializedName("profile_path")
    private String profilePath;


}
