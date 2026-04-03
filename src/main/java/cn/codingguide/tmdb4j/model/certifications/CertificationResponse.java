package cn.codingguide.tmdb4j.model.certifications;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-02
 */
@Getter
@Setter
@ToString
public class CertificationResponse {

    /**
     * 国家/地区代码（ISO 3166-1）到该国家分级列表的映射
     * 例如：{"US": [Certification对象], "CN": [Certification对象]}
     */
    private Map<String, List<Certification>> certifications;

}
