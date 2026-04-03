package cn.codingguide.tmdb4j.model.person;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a person (actor, director, etc.) from TMDB.
 * <p>
 * 表示 TMDB 中的一个人物（演员、导演等）。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class Person {

    /**
     * The unique identifier of the person.
     * 人物的唯一标识符。
     */
    private int id;

    /**
     * The name of the person.
     * 人物的姓名。
     */
    private String name;

    /**
     * The original name of the person.
     * 人物的原始姓名。
     */
    @SerializedName("original_name")
    private String originalName;

    /**
     * The popularity score of the person.
     * 人物的热度指数。
     */
    private double popularity;

    /**
     * The gender of the person (0 = not specified, 1 = female, 2 = male).
     * 人物的性别（0 = 未指定，1 = 女性，2 = 男性）。
     */
    private int gender;

    /**
     * The department the person is known for (e.g., "Acting", "Directing").
     * 人物的主要知名部门（例如 "Acting", "Directing"）。
     */
    @SerializedName("known_for_department")
    private String knownForDepartment;

    /**
     * The profile image path of the person.
     * Append this to the TMDB image base URL to get the full image.
     * 人物的头像图片路径。将此路径附加到 TMDB 图片基础 URL 以获取完整图片。
     */
    @SerializedName("profile_path")
    private String profilePath;

    /**
     * Indicates whether the person is considered adult content.
     * 表示该人物是否属于成人内容。
     */
    private boolean adult;

}
