package com.pj.jpatest.service;

import com.pj.jpatest.domain.Book;
import com.pj.jpatest.dto.BookInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public interface BookService {
    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Collection<BookInfo> findAll();

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book createNewBook();

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Book updateBook(@PathVariable Long id);

    void deleteBook(@PathVariable Long id);
}
