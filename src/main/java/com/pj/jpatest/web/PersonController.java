package com.pj.jpatest.web;

import com.pj.jpatest.domain.Person;
import com.pj.jpatest.service.PersonService;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.*;

/**
 * Provides a REST API endpoints for the Person entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * Create a new Person record and save it to the database.
     *
     * @return the newly created Person
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Person create() {
        return service.create();
    }

    @GetMapping("/update/{id}")
    public Person update(@PathVariable Long id) {
        return service.update(id);
    }

    @GetMapping("/revisions/{id}")
    public Revisions<Integer, Person> getRevisions(@PathVariable Long id) {
        return service.getRevisions(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}