package cn.codingguide.tmdb4j.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 评分
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RatingRequest {

    private double value;

}
