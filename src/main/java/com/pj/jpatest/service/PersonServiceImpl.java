package com.pj.jpatest.service;

import com.pj.jpatest.domain.Address;
import com.pj.jpatest.domain.Person;
import com.pj.jpatest.repository.PersonRepository;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
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

    @Override
    public Person update(Long id) {
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

    @Override
    public Revisions<Integer, Person> getRevisions(Long id) {
        return personRepository.findRevisions(id);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}