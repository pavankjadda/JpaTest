package com.pj.jpatest.web;

import com.pj.jpatest.domain.Book;
import com.pj.jpatest.dto.BookInfo;
import com.pj.jpatest.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Provides a REST API endpoints for the Book entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * Find all Books in the database.
     *
     * @return list of Books or an empty list if no Books are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public Collection<BookInfo> findAll() {
        return service.findAll();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @PostMapping("/create")
    public Book createNewBook() {
        return service.createNewBook();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Long id) {
        return service.updateBook(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}
