package com.pj.jpatest.repository;

import com.pj.jpatest.domain.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
    BookType findByName(String name);
}
