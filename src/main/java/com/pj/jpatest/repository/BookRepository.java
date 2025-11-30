package com.pj.jpatest.repository;

import com.pj.jpatest.domain.Book;
import com.pj.jpatest.dto.BookDto;
import com.pj.jpatest.dto.BookInfo;
import com.pj.jpatest.dto.BookSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Integer> {
    List<BookInfo> findAllByIsbnIsNotNull();

    //@Query("SELECT new com.pj.jpatest.dto.BookSummary(b.id, b.isbn, b.yearOfPublication) FROM Book b")
    @Query("SELECT new com.pj.jpatest.dto.BookSummary(b.id, b.isbn, b.yearOfPublication) FROM Book b")
    List<BookSummary> findAllSlim();

    // Class based or interface projections work without constructor as long as Spring Data derived query is valid
    List<BookDto> findDistinctByIsbnIsNotNull();
}