package cn.codingguide.tmdb4j.model.tvs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a TV episode with the user's personal rating.
 * Extends the basic TvEpisode class and adds rating and rated time.
 * <p>
 * 表示带有用户个人评分的电视剧剧集。
 * 继承基础 TvEpisode 类，并增加评分和评分时间字段。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString(callSuper = true)
public class RatedTvEpisode extends TvEpisode {

    /**
     * The user's personal rating for the episode, typically in range 0.5 ~ 10.0 (step 0.5).
     * 用户对该剧集的个人评分，通常取值范围为 0.5 ~ 10.0（步进 0.5）。
     */
    private double rating;

}
