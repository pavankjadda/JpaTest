package com.pj.jpatest.service;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.domain.AuthorLog;
import com.pj.jpatest.repository.AuthorLogRepository;
import com.pj.jpatest.repository.AuthorRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AuthorServiceIpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorLogRepository authorLogRepository;

    public AuthorServiceIpl(AuthorRepository authorRepository, AuthorLogRepository authorLogRepository) {
        this.authorRepository = authorRepository;
        this.authorLogRepository = authorLogRepository;
    }

    @Override
    public Author createNewAuthor() {
        var author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setEmail("jdoe2@example.com");
        author.setPhoneNumber("1234567890");
        return authorRepository.saveAndFlush(author);
    }

    @Override
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

    @Override
    public void delete(String email) {
        var author = authorRepository.findByEmail(email);
        authorRepository.delete(author);
        saveLog(author.getFirstName(), author.getLastName(), author.getEmail(), author.getPhoneNumber());
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
}