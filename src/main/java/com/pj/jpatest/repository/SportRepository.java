package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}