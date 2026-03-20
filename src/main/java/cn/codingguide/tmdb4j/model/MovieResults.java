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
public class MovieResults {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<Movie> results;

}
