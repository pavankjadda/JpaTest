package com.pj.jpatest.web;

import com.pj.jpatest.domain.Address;
import com.pj.jpatest.domain.Person;
import com.pj.jpatest.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Provides a REST API endpoints for the Person entity.
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
        Person person = new Person();
        var personId = new Random().nextLong();
        person.setId(personId);
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("jdoe@example.com");
        person.setPhoneNumber("123-456-7890");

        var address = new Address();
        address.setAddressLine1("123 Main St");
        address.setAddressLine2("Apt 101");
        address.setCity("Cupertino");
        address.setZipCode("12345");
        person.setHomeAddress(address);
        return personRepository.saveAndFlush(person);
    }
}
