package cn.codingguide.tmdb4j.model.account;

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
    // iso_639_1 是 ISO 639-1 标准的 两字母语言代码，例如 "en" 表示英语，"zh" 表示中文。在 TMDB API 中，它用于标识电影/电视剧的原始语言、配音语言、字幕语言等信息。
    @SerializedName("iso_639_1")
    private String language;
    @SerializedName("iso_3166_1")
    // iso_3166_1 是国际标准化组织（ISO）发布的国家/地区代码标准，国家或者地区：如 "US", "CN", "CA"
    private String region;

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
