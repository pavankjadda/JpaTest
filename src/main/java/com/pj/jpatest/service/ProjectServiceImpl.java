package com.pj.jpatest.service;

import com.pj.jpatest.domain.Project;
import com.pj.jpatest.domain.ProjectType;
import com.pj.jpatest.dto.request.ProjectCreateRequest;
import com.pj.jpatest.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link com.pj.jpatest.domain.Project}.
 *
 * @author Pavan Kumar Jadda
 * @since 1.3.0
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all Projects in the database.
     *
     * @return list of Projects or an empty list if no Projects are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.3.0
     */
    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    /**
     * Create a new Project and persist it to the database.
     *
     * @return the newly created Project
     *
     * @author Pavan Kumar Jadda
     * @since 1.3.0
     */
    @Override
    public Project createNewProject(ProjectCreateRequest request) {
        var project = new Project();
        project.setName(request.name());
        project.setDescription(request.description());
        project.setLocation(request.location());
        project.setProjectType(ProjectType.fromString(request.type()));
        return repository.saveAndFlush(project);
    }
}