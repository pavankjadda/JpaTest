package com.pj.jpatest.web;

import com.pj.jpatest.domain.Sport;
import com.pj.jpatest.dto.request.CreateSportRequest;
import com.pj.jpatest.service.SportService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a REST API endpoint for the Sport
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/sport")
public class SportController {
    private final SportService service;

    public SportController(SportService service) {
        this.service = service;
    }

    /**
     * Find all Sports in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping(value = "/find/all")
    public List<Sport> findAll() {
        return service.findAll();
    }

    /**
     * Create a new Sport in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @PostMapping("/create")
    public Sport create(CreateSportRequest request) {
        return service.createSport(request);
    }
}