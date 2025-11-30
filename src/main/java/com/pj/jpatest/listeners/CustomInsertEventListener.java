package com.pj.jpatest.listeners;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class CustomInsertEventListener implements PostInsertEventListener {
    @Override
    public void onPostInsert(PostInsertEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomInsertEventListener.onPostInsert: " + entity);
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