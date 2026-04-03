package cn.codingguide.tmdb4j.model.movies;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a movie with the user's personal rating.
 * Extends the basic Movie class and adds rating and rated time.
 * <p>
 * 表示带有用户个人评分的电影。
 * 继承基础 Movie 类，并增加评分和评分时间字段。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString(callSuper = true)
public class RatedMovie extends Movie {

    /**
     * The user's personal rating for the TV series, typically in range 0.5 ~ 10.0 (step 0.5).
     * 用户对该电视剧的个人评分，通常取值范围为 0.5 ~ 10.0（步进 0.5）。
     */
    private double rating;

}
