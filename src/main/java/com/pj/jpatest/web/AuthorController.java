package com.pj.jpatest.web;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.repository.AuthorRepository;
import com.pj.jpatest.service.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides a REST API endpoints for the Author entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    /**
     * Find all Authors in the database.
     *
     * @return list of Authors or an empty list if no Authors are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    /**
     * Create a new Author and persist it to the database.
     *
     * @return the newly created Author
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Author createNewAuthor() {
        return authorService.createNewAuthor();
    }

    /**
     * Update the Author and persist it to the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update/{email}")
    public void update(@PathVariable String email) {
        authorService.update(email);
    }

    /**
     * Deleted the Author by email
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/delete/{email}")
    public void delete(@PathVariable String email) {
        authorService.delete(email);
    }
}