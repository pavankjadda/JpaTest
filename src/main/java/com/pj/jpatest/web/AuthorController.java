package com.pj.jpatest.web;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.domain.AuthorLog;
import com.pj.jpatest.repository.AuthorLogRepository;
import com.pj.jpatest.repository.AuthorRepository;
import com.pj.jpatest.service.AuthorService;
import org.springframework.scheduling.annotation.Async;
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
    private final AuthorLogRepository authorLogRepository;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService, AuthorLogRepository authorLogRepository) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.authorLogRepository = authorLogRepository;
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
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setEmail("jdoe2@example.com");
        author.setPhoneNumber("1234567890");
        return authorRepository.saveAndFlush(author);
    }

    /**
     * Update the Author and persist it to the database.
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/update/{email}")
    public void update(@PathVariable String email) {
        var author = authorRepository.findByEmail(email);
        if (author != null) {
            author.setFirstName("John");
            author.setLastName("Doe");
            author.setEmail("jdoe2@example.com");
            author.setPhoneNumber("1234567890");
            authorRepository.saveAndFlush(author);
            saveLog(author.getFirstName(), author.getLastName(), author.getEmail(), author.getPhoneNumber());
        }
    }

    @Async
    protected void saveLog(String firstName, String lastName, String email, String phoneNumber) {
        var authorLog = new AuthorLog();
        authorLog.setFirstName(firstName);
        authorLog.setLastName(lastName);
        authorLog.setEmail(email);
        authorLog.setPhoneNumber(phoneNumber);
        authorLogRepository.saveAndFlush(authorLog);
        System.out.println("Saved authorLog in thread:" + Thread.currentThread().getName());
    }

    @GetMapping("/test")
    public void updateTransactional() {
        authorService.updateTransactional();
    }
}
