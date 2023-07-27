package com.pj.jpatest.service;

public interface AuthorService {
    void delete(String email);

    void updateTransactional();
}
