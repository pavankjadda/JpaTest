package com.pj.jpatest.service;

import com.pj.jpatest.domain.Project;
import com.pj.jpatest.dto.request.ProjectCreateRequest;

import java.util.List;

public interface ProjectService {
    /**
     * Find all Projects in the database.
     *
     * @return list of Projects or an empty list if no Projects are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Project> findAll();

    /**
     * Create a new Project and persist it to the database.
     *
     * @return the newly created Project
     *
     * @author Pavan Kumar Jadda
     * @since 1.3.0
     */
    Project createNewProject(ProjectCreateRequest request);
}