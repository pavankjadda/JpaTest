package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}