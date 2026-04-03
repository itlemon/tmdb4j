package cn.codingguide.tmdb4j.model.changes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class ChangedMovie {

    /**
     * The unique identifier of the movie that has changed.
     * 发生变更的电影的唯一标识符。
     */
    private int id;

    /**
     * Indicates whether the movie is considered adult content.
     * Note: If the movie has been deleted, this field may be null.
     * 表示该电影是否属于成人内容。
     * 注意：如果该电影已被删除，此字段可能为 null。
     */
    private Boolean adult;

}
