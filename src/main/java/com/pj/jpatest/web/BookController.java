package com.pj.jpatest.web;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.domain.Book;
import com.pj.jpatest.dto.BookInfo;
import com.pj.jpatest.repository.AuthorRepository;
import com.pj.jpatest.repository.BookRepository;
import com.pj.jpatest.repository.BookTypeRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final BookRepository bookRepository;
    private final BookTypeRepository bookTypeRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, BookTypeRepository bookTypeRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
        this.authorRepository = authorRepository;
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
        return bookRepository.findAllByIsbnIsNotNull();
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Book createNewBook() {
        Book book = new Book();
        book.setTitle("Spring Boot 2 Recipes");
        book.setIsbn("978-1-4842-3925-4");
        book.setEdition(1);
        book.setYearOfPublication(2018);
        book.setPublisher("OReilly Media");
        book.setBookType(bookTypeRepository.findByName("Paper Back"));
        return bookRepository.saveAndFlush(book);
    }

    /**
     * Create a new Book and persist it to the database.
     *
     * @return the newly created Book
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update")
    public Book updateBook() {
        var book = bookRepository.findByIsbn("978-1-4842-3925-4");
        book.setTitle("Spring Boot 3 Recipes");
        book.setEdition(2);
        book.setYearOfPublication(2019);
        book.setPublisher("Personal Publication");
        book.setBookType(bookTypeRepository.findByName("Kindle"));
        var author = authorRepository.saveAndFlush(new Author("John", "Doe", "jdoe@example.com", "123-456-7890"));
        book.getAuthors().add(author);
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/delete")
    public void deleteBook() {
        bookRepository.deleteByIsbn("978-1-4842-3925-4");
    }
}
