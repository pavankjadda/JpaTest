package com.pj.jpatest.service;

import com.pj.jpatest.domain.Author;
import java.util.List;

public interface AuthorService {
    Author createNewAuthor();

    void update(String email);

    void delete(String email);

    void saveLog(String firstName, String lastName, String email, String phoneNumber);

    /**
     * Find all Authors in the database.
     *
     * @return list of Authors or an empty list if no Authors are found
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Author> findAll();
}