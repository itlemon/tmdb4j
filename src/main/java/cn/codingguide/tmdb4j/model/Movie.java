package cn.codingguide.tmdb4j.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@Getter
@Setter
@ToString
public class Movie {

    private int id;
    private String title;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    private boolean adult;
    private boolean video;
    private double popularity;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;

}
