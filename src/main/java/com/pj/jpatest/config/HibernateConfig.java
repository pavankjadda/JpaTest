package com.pj.jpatest.config;

import com.pj.jpatest.listeners.CustomPreInsertEventListener;
import com.pj.jpatest.listeners.CustomSaveOrUpdateEventListener;
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
    private final CustomPreInsertEventListener preInsertEventListener;
    private final CustomSaveOrUpdateEventListener saveOrUpdateEventListener;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public HibernateConfig(CustomSaveOrUpdateEventListener saveOrUpdateEventListener, CustomPreInsertEventListener preInsertEventListener) {
        this.saveOrUpdateEventListener = saveOrUpdateEventListener;
        this.preInsertEventListener = preInsertEventListener;
    }

    @PostConstruct
    protected void init() {
        var sessionFactory = emf.unwrap(SessionFactoryImpl.class);
        var registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
//        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(preInsertEventListener);
//        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(preInsertEventListener);
//        registry.getEventListenerGroup(EventType.PRE_DELETE).appendListener(preInsertEventListener);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(saveOrUpdateEventListener);
        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(saveOrUpdateEventListener);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(saveOrUpdateEventListener);
    }
}
