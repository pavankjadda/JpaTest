package com.pj.jpatest.service;

import com.pj.jpatest.domain.Author;

public interface AuthorService {
    Author createNewAuthor();

    void update(String email);

    void delete(String email);
}