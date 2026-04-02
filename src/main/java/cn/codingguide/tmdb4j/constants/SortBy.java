package cn.codingguide.tmdb4j.constants;

import lombok.Getter;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
public enum SortBy {

    CREATED_AT_ASC("created_at.asc"),
    CREATED_AT_DESC("created_at.desc");

    private final String value;

    SortBy(String value) {
        this.value = value;
    }
}
