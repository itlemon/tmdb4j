package cn.codingguide.tmdb4j.model.configuration;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a department and its associated jobs in the TMDB configuration.
 * Used for understanding available job types for movie/TV crew members.
 * <p>
 * 表示 TMDB 配置中的部门及其关联的工作岗位。
 * 用于了解电影/电视剧剧组人员的可用工作类型。
 * </p>
 *
 * @author itlemon {@literal <itlemon@petalmail.com>}
 * Created on 2026-04-03
 */
@Getter
@Setter
@ToString
public class JobDepartment {

    /**
     * The name of the department (e.g., "Crew", "Directing", "Writing").
     * 部门的名称（例如 "Crew", "Directing", "Writing"）。
     */
    private String department;

    /**
     * The list of job titles within this department (e.g., "Stunt Coordinator", "Second Unit").
     * 该部门内的工作岗位名称列表（例如 "Stunt Coordinator", "Second Unit"）。
     */
    private List<String> jobs;


}
