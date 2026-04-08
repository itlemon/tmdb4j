package cn.codingguide.tmdb4j.model.lists;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Request body for creating a new user-defined list.
 * <p>
 * 创建新的用户自定义列表的请求体。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-07
 */
@Getter
@Setter
@Builder
@ToString
public class CreateListRequest {

    /**
     * The name of the list (required).
     * 列表的名称（必填）。
     */
    private String name;

    /**
     * The description of the list (optional).
     * 列表的描述（可选）。
     */
    private String description;

    /**
     * The ISO 639-1 language code for the list (optional, default "en-US").
     * 列表的 ISO 639-1 语言代码（可选，默认 "en-US"）。
     */
    private String language;

}
