package cn.codingguide.tmdb4j.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString(callSuper = true)
public class RatedTvEpisode extends TvEpisode {

    /**
     * 当前用户对该剧集的评分，取值范围为 0.5 ~ 10.0，步进 0.5
     */
    private double rating;

}
