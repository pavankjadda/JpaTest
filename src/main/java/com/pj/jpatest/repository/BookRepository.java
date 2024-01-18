package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Integer> {
    void deleteByIsbn(String isbn);

    Book findByIsbn(String isbn);
}
