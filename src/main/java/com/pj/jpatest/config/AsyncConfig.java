package com.pj.jpatest.config;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Configuration class that defines Thread Pool and Executor configuration for Async tasks
 *
 * @author Pavan Kumar Jadda
 * @since 2.0.0
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    /**
     * Creates {@link ThreadPoolTaskExecutor} and sets its properties
     *
     * @author Pavan Kumar Jadda
     * @since 2.0.0
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("JPA-Async-Thread-");
        executor.initialize();
        return executor;
    }
}