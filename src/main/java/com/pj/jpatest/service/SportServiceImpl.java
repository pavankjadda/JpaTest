package com.pj.jpatest.service;

import com.pj.jpatest.domain.Sport;
import com.pj.jpatest.dto.request.CreateSportRequest;
import com.pj.jpatest.repository.SportRepository;
import java.util.List;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SportServiceImpl implements SportService {
    private final SportRepository repository;

    public SportServiceImpl(SportRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all Sports in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public List<Sport> findAll() {
        return repository.findAll();
    }

    /**
     * Create a new Sport in the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Sport createSport(CreateSportRequest request) {
        var faker = new Faker();
        var sport = new Sport(faker.cricket().teams(), request.players(), request.ageGroup(), request.description());
        return repository.saveAndFlush(sport);
    }
}