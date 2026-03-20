package cn.codingguide.tmdb4j.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-03-20
 */
@Getter
@Setter
@ToString
public class Account {

    private int id;
    private String name;
    private String username;
    @SerializedName("avatar")
    private Avatar avatar;
    @SerializedName("include_adult")
    private boolean includeAdult;
    @SerializedName("iso_639_1")
    private String language;

    @Getter
    @Setter
    @ToString
    public static class Avatar {
        private Gravatar gravatar;
        private Tmdb tmdb;

        @Getter
        @Setter
        @ToString
        public static class Gravatar {
            private String hash;
        }

        @Getter
        @Setter
        @ToString
        public static class Tmdb {
            @SerializedName("avatar_path")
            private String avatarPath;
        }
    }
}
