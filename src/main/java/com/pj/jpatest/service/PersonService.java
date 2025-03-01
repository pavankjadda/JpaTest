package com.pj.jpatest.service;

import com.pj.jpatest.domain.Person;
import org.springframework.data.history.Revisions;

public interface PersonService {
    Person create();

    Person update(Long id);

    Revisions<Integer, Person> getRevisions(Long id);

    void deleteById(Long id);
}