package cn.codingguide.tmdb4j.model.companies;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response of the company alternative names API.
 * Contains a list of alternative names for the company.
 * <p>
 * 表示公司备选名称 API 的响应。
 * 包含公司的备选名称列表。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class CompanyAlternativeNamesResponse {

    /**
     * The unique identifier of the company.
     * 公司的唯一标识符。
     */
    private int id;

    /**
     * List of alternative names for the company.
     * 公司的备选名称列表。
     */
    private List<CompanyAlternativeName> results;

}
