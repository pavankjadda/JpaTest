package com.pj.jpatest.listeners;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class CustomUpdateEventListener implements PostUpdateEventListener {
    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomInsertEventListener.onPostUpdate: " + entity);
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