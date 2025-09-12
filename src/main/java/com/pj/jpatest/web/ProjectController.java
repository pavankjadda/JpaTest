package com.pj.jpatest.web;

import com.pj.jpatest.domain.Project;
import com.pj.jpatest.dto.request.ProjectCreateRequest;
import com.pj.jpatest.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Provides a REST API endpoints for the Project entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    /**
     * Find all Projects in the database.
     *
     * @return list of Projects or an empty list if no Projects are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public List<Project> findAll() {
        return service.findAll();
    }

    /**
     * Create a new Project and persist it to the database.
     *
     * @return the newly created Project
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @PostMapping("/create")
    public Project createNewProject(@RequestBody ProjectCreateRequest request) {
        return service.createNewProject(request);
    }
}