package cn.codingguide.tmdb4j.model.companies;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a single alternative name entry for a company.
 * Contains the name and the language/country code for which this name is used.
 * <p>
 * 表示公司的一个备选名称条目。
 * 包含名称以及使用该名称的语言/国家代码。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CompanyAlternativeName {

    /**
     * The alternative name of the company.
     * 公司的备选名称。
     */
    private String name;

    /**
     * The type of the alternative name (e.g., "AKA", "Short name", etc.).
     * 备选名称的类型（例如 "AKA"、"Short name" 等）。
     */
    private String type;

}
