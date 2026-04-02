package cn.codingguide.tmdb4j.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 单个分级条目
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class Certification {

    /**
     * 分级代号，例如 "R", "PG-13", "大众级"
     */
    private String certification;

    /**
     * 分级的含义描述，例如 "Restricted", "Parents Strongly Cautioned"
     */
    private String meaning;

    /**
     * 排序顺序，数字越小表示限制越宽松（通常用于前端排序）
     */
    private int order;

}
