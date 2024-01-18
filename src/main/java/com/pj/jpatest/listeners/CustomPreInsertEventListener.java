package com.pj.jpatest.listeners;

import org.hibernate.event.spi.*;
import org.springframework.stereotype.Component;

@Component
public class CustomPreInsertEventListener implements PreInsertEventListener, PreDeleteEventListener, PreUpdateEventListener {
    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        final Object entity = event.getEntity();

        System.out.println("CustomPreInsertEventListener.onPreInsert: " + entity);

        return false;
    }

    /**
     * Return true if the operation should be vetoed
     *
     * @param event
     */
    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        final Object entity = event.getEntity();

        System.out.println("CustomPreInsertEventListener.onPreDelete: " + entity);
        return false;
    }

    /**
     * Return true if the operation should be vetoed
     *
     * @param event
     */
    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        final Object entity = event.getEntity();
        System.out.println("CustomPreInsertEventListener.onPreUpdate: " + entity);
        return false;
    }
}
