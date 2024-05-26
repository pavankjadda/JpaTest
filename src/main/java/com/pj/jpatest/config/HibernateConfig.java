package com.pj.jpatest.config;

import com.pj.jpatest.listeners.CustomDeleteEventListener;
import com.pj.jpatest.listeners.CustomInsertEventListener;
import com.pj.jpatest.listeners.CustomUpdateEventListener;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that defines Thread Pool and Executor configuration for Async tasks
 *
 * @author Pavan Kumar Jadda
 * @since 2.0.0
 */
@Configuration
public class HibernateConfig {
    private final CustomDeleteEventListener deleteEventListener;
    private final CustomInsertEventListener insertEventListener;
    private final CustomUpdateEventListener updateEventListener;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public HibernateConfig(CustomInsertEventListener insertEventListener, CustomDeleteEventListener deleteEventListener,
                           CustomUpdateEventListener updateEventListener) {
        this.insertEventListener = insertEventListener;
        this.deleteEventListener = deleteEventListener;
        this.updateEventListener = updateEventListener;
    }

    @PostConstruct
    protected void init() {
        var sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        var registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
//        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(preInsertEventListener);
//        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(preInsertEventListener);
//        registry.getEventListenerGroup(EventType.PRE_DELETE).appendListener(preInsertEventListener);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(updateEventListener);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(insertEventListener);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(deleteEventListener);
    }
}
