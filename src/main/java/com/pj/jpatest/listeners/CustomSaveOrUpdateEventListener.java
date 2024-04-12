package com.pj.jpatest.listeners;

import jakarta.persistence.EntityManager;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class CustomSaveOrUpdateEventListener implements PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener {
    private final EntityManager entityManager;

    public CustomSaveOrUpdateEventListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomSaveOrUpdateEventListener.onPostDelete: " + entity);
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomSaveOrUpdateEventListener.onPostInsert: " + entity);
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomSaveOrUpdateEventListener.onPostUpdate: " + entity);
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
