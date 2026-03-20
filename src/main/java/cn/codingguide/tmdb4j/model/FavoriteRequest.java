package cn.codingguide.tmdb4j.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 标记收藏
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FavoriteRequest {

    // "movie" or "tv"
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("media_id")
    private int mediaId;
    private boolean favorite;


}
