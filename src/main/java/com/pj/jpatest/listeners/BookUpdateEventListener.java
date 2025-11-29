package com.pj.jpatest.listeners;

import com.pj.jpatest.domain.Book;
import com.pj.jpatest.domain.BookLog;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
public class BookUpdateEventListener implements PostUpdateEventListener {
    private final EntityManager entityManager;

    public BookUpdateEventListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        final Object entity = event.getEntity();
        if (entity instanceof Book book) {
            log.info("BookUpdateEventListener.onPostUpdate: {}", book);
            entityManager.persist(new BookLog("Book %s updated and details are %s".formatted(book.getId(), book), Instant.now(), "System"));
        }
    }

    /**
     * Does this listener require that after transaction hooks be registered?
     *
     * @param persister The persister for the entity in question.
     *
     * @return {@code true} if after transaction callbacks should be added.
     */
    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return false;
    }
}
