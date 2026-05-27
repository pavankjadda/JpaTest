package com.pj.jpatest.service;

import com.pj.jpatest.domain.Sport;
import com.pj.jpatest.dto.request.CreateSportRequest;
import java.util.List;

public interface SportService {
    /**
     * Find all Sports in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Sport> findAll();

    /**
     * Create a new Sport in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Sport createSport(CreateSportRequest request);
}