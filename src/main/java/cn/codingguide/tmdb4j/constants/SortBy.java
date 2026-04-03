package cn.codingguide.tmdb4j.constants;

import lombok.Getter;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
public enum SortBy {

    CREATED_AT_ASC("created_at.asc"),
    CREATED_AT_DESC("created_at.desc"),

    FIRST_AIR_DATE_ASC("first_air_date.asc"),
    FIRST_AIR_DATE_DESC("first_air_date.desc"),

    PRIMARY_RELEASE_DATE_ASC("primary_release_date.asc"),
    PRIMARY_RELEASE_DATE_DESC("primary_release_date.desc"),

    NAME_ASC("name.asc"),
    NAME_DESC("name.desc"),

    ORIGINAL_TITLE_ASC("original_title.asc"),
    ORIGINAL_TITLE_DESC("original_title.desc"),

    TITLE_ASC("title.asc"),
    TITLE_DESC("title.desc"),

    ORIGINAL_NAME_ASC("original_name.asc"),
    ORIGINAL_NAME_DESC("original_name.desc"),

    POPULARITY_ASC("popularity.asc"),
    POPULARITY_DESC("popularity.desc"),

    REVENUE_ASC("revenue.asc"),
    REVENUE_DESC("revenue.desc"),

    VOTE_AVERAGE_ASC("vote_average.asc"),
    VOTE_AVERAGE_DESC("vote_average.desc"),

    VOTE_COUNT_ASC("vote_count.asc"),
    VOTE_COUNT_DESC("vote_count.desc");

    private final String value;

    SortBy(String value) {
        this.value = value;
    }
}
