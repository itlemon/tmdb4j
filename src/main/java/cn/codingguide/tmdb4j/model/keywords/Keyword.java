package cn.codingguide.tmdb4j.model.keywords;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a keyword in the TMDB system.
 * Keywords are tags that describe specific concepts, themes, or objects related to movies or TV shows.
 * <p>
 * 表示 TMDB 系统中的关键词。
 * 关键词是描述电影或电视剧相关特定概念、主题或对象的标签。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@Getter
@Setter
@ToString
public class Keyword {

    /**
     * The unique identifier of the keyword.
     * 关键词的唯一标识符。
     */
    private int id;

    /**
     * The name of the keyword.
     * 关键词的名称。
     */
    private String name;

}
