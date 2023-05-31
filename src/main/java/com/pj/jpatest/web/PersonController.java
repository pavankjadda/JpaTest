package com.pj.jpatest.web;

import com.pj.jpatest.domain.Address;
import com.pj.jpatest.domain.Person;
import com.pj.jpatest.repository.PersonRepository;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update/{id}")
    public Person update(@PathVariable Long id) {
        var personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            var person = personOptional.get();
            person.setFirstName("Jack");
            person.setLastName("Ryan");
            person.setEmail("jdoe@example.com");
            person.setPhoneNumber("123-456-7890");
            return personRepository.saveAndFlush(person);
        }
        return null;
    }

    @GetMapping("/revisions/{id}")
    public Revisions<Integer, Person> getRevisions(@PathVariable Long id) {
        return personRepository.findRevisions(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
