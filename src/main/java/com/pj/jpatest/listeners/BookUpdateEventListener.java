package com.pj.jpatest.listeners;

import com.pj.jpatest.domain.Book;
import com.pj.jpatest.domain.BookLog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PostUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Component
@Slf4j
public class BookUpdateEventListener {
    private final EntityManager entityManager;

    public BookUpdateEventListener(@Lazy EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostUpdate
    @Transactional
    public void onPostUpdate(Object entity) {
        var book = (Book) entity;
        log.info("BookUpdateEventListener.onPostUpdate: {}", book);
        entityManager.persist(new BookLog("Book %s updated and details are %s".formatted(book.getId(), book), Instant.now(), "System"));
    }
}
