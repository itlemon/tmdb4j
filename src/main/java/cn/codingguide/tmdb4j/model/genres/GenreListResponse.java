package cn.codingguide.tmdb4j.model.genres;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response wrapper for a list of genres.
 * <p>
 * 类型列表的响应包装类。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class GenreListResponse {

    /**
     * List of genres.
     * 类型列表。
     */
    private List<Genre> genres;

}
