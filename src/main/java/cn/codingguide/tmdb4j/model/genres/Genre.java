package cn.codingguide.tmdb4j.model.genres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a genre (e.g., Action, Comedy) from TMDB.
 * <p>
 * 表示 TMDB 中的类型（例如动作、喜剧）。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class Genre {

    /**
     * The unique identifier of the genre.
     * 类型的唯一标识符。
     */
    private int id;

    /**
     * The name of the genre (localized based on the language parameter).
     * 类型的名称（根据语言参数本地化）。
     */
    private String name;

}
