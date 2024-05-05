package com.pj.jpatest;

import com.pj.jpatest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {JpaTestApplication.class})
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindAllSlim() {
        var books = bookRepository.findAllSlim();
        assertFalse(books.isEmpty());
        System.out.println(books);
    }

    @Test
    void testFindDistinctByIsbnIsNotNull() {
        var books = bookRepository.findDistinctByIsbnIsNotNull();
        assertFalse(books.isEmpty());
        System.out.println(books);
    }
}
