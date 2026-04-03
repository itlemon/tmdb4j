package cn.codingguide.tmdb4j.model.changes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class ChangedPerson {

    /**
     * The unique identifier of the person that has changed.
     * 发生变更的人员的唯一标识符。
     */
    private int id;

    /**
     * Indicates whether the person is considered adult content.
     * Note: If the person has been deleted, this field may be null.
     * 表示该人员是否属于成人内容。
     * 注意：如果该人员已被删除，此字段可能为 null。
     */
    private Boolean adult;

}
