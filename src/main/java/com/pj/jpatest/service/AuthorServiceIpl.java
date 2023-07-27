package com.pj.jpatest.service;

import com.pj.jpatest.domain.Author;
import com.pj.jpatest.repository.AuthorRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceIpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceIpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void delete(String email) {
        Author author = authorRepository.findByEmail(email);
        authorRepository.delete(author);
        saveLog();
    }

    @Override
    @Transactional
    public void updateTransactional() {
        var authors = authorRepository.findAll();
        for (var author : authors) {
            saveAuthors(author);
        }
    }
    
    public void saveAuthors(Author author) {
        author.setFirstName("transactional");
        authorRepository.save(author);
        throw new RuntimeException("Transactional");
    }

    @Async
    protected void saveLog() {
        System.out.println("Saved log" + Thread.currentThread().getName());
    }
}
