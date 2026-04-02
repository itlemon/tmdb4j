package cn.codingguide.tmdb4j.model;

import cn.codingguide.tmdb4j.constants.MediaType;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-01
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WatchlistRequest {

    // "movie" or "tv"
    @SerializedName("media_type")
    private MediaType mediaType;
    @SerializedName("media_id")
    private int mediaId;
    private boolean watchlist;

}
