package cn.codingguide.tmdb4j.model.find;

import java.util.List;

import cn.codingguide.tmdb4j.model.movies.Movie;
import cn.codingguide.tmdb4j.model.person.Person;
import cn.codingguide.tmdb4j.model.tvs.TvEpisode;
import cn.codingguide.tmdb4j.model.tvs.TvSeason;
import cn.codingguide.tmdb4j.model.tvs.TvSeries;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Response for the find endpoint, which looks up TMDB items by external ID.
 * Contains lists of different media types that match the external ID.
 * <p>
 * 查找端点的响应，通过外部 ID 查找 TMDB 条目。
 * 包含匹配外部 ID 的不同媒体类型的列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class FindResponse {

    /**
     * List of movies matching the external ID.
     * 匹配外部 ID 的电影列表。
     */
    @SerializedName("movie_results")
    private List<Movie> movieResults;

    /**
     * List of TV series matching the external ID.
     * 匹配外部 ID 的电视剧列表。
     */
    @SerializedName("tv_results")
    private List<TvSeries> tvResults;

    /**
     * List of TV episodes matching the external ID.
     * 匹配外部 ID 的电视剧剧集列表。
     */
    @SerializedName("tv_episode_results")
    private List<TvEpisode> tvEpisodeResults;

    /**
     * List of TV seasons matching the external ID.
     * 匹配外部 ID 的电视剧季列表。
     */
    @SerializedName("tv_season_results")
    private List<TvSeason> tvSeasonResults;

    /**
     * List of persons matching the external ID.
     * 匹配外部 ID 的人物列表。
     */
    @SerializedName("person_results")
    private List<Person> personResults;

}