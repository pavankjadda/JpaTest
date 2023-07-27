package com.pj.jpatest.repository;

import com.pj.jpatest.domain.AuthorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorLogRepository extends JpaRepository<AuthorLog, Long> {
}
