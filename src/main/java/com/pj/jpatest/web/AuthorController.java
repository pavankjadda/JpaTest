package com.pj.jpatest.web;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.service.AuthorService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a REST API endpoints for the Author entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
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
        return service.findAll();
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
        return service.createNewAuthor();
    }

    /**
     * Update the Author and persist it to the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update/{email}")
    public void update(@PathVariable String email) {
        service.update(email);
    }

    /**
     * Deleted the Author by email
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/delete/{email}")
    public void delete(@PathVariable String email) {
        service.delete(email);
    }
}