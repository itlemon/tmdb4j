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
public class ChangedTvSeries {

    /**
     * The unique identifier of the TV series that has changed.
     * 发生变更的电视剧的唯一标识符。
     */
    private int id;

    /**
     * Indicates whether the TV series is considered adult content.
     * Note: If the TV series has been deleted, this field may be null.
     * 表示该电视剧是否属于成人内容。
     * 注意：如果该电视剧已被删除，此字段可能为 null。
     */
    private Boolean adult;

}
