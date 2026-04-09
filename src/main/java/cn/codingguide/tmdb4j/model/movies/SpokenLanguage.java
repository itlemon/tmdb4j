package cn.codingguide.tmdb4j.model.movies;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A language spoken in the movie.
 * <p>
 * 电影中使用的口语语言。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-09
 */
@Getter
@Setter
@ToString
public class SpokenLanguage {

    /**
     * The English name of the language.
     * 语言的英文名称。
     */
    @SerializedName("english_name")
    private String englishName;

    /**
     * The ISO 639-1 language code.
     * ISO 639-1 语言代码。
     */
    @SerializedName("iso_639_1")
    private String languageCode;

    /**
     * The native name of the language.
     * 语言的本土名称。
     */
    private String name;

}
