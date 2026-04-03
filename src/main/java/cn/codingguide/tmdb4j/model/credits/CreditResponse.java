package cn.codingguide.tmdb4j.model.credits;

import cn.codingguide.tmdb4j.constants.CreditType;
import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the credit (cast/crew) details API.
 * Contains information about a specific credit, including the associated media and person.
 * <p>
 * 表示演职员详情 API 的响应。
 * 包含特定演职员记录的信息，包括关联的媒体和人员。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CreditResponse {

    /**
     * The type of credit, either "cast" or "crew".
     * 演职员类型，可以是 "cast"（演员）或 "crew"（剧组人员）。
     */
    @SerializedName("credit_type")
    private CreditType creditType;

    /**
     * The department of the crew member (e.g., "Acting", "Directing"). May be null for cast.
     * 剧组人员所属部门（例如 "Acting", "Directing"）。对于演员可能为 null。
     */
    private String department;

    /**
     * The specific job title of the crew member (e.g., "Actor", "Director"). May be null for cast.
     * 剧组人员的具体职位（例如 "Actor", "Director"）。对于演员可能为 null。
     */
    private String job;

    /**
     * The media (movie or TV show) associated with this credit.
     * 与此演职员记录关联的媒体（电影或电视剧）。
     */
    private CreditMedia media;

    /**
     * The type of the media, either "movie" or "tv". Redundant but present in the response.
     * 媒体类型，可以是 "movie" 或 "tv"。响应中存在，可能冗余。
     */
    @SerializedName("media_type")
    private MediaType mediaType;

    /**
     * The unique identifier of this credit record.
     * 此演职员记录的唯一标识符。
     */
    private String id;

    /**
     * The person (actor or crew) associated with this credit.
     * 与此演职员记录关联的人员（演员或剧组人员）。
     */
    private CreditPerson person;

}
