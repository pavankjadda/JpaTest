package com.pj.jpatest.service;

import com.pj.jpatest.domain.OrderItem;
import com.pj.jpatest.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkerThread implements Runnable {
    private final OrderRepository orderRepository;

    public WorkerThread(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        var order = orderRepository.findById(2L).orElse(null);
        if (order != null) {
            if (order.getOrderItems().stream().anyMatch(oi -> oi.getName().equals("iPhone 15"))) {
                System.out.println("iPhone 15 present, hence skipping it");
            } else {
                order.getOrderItems().add(new OrderItem("iPhone 15", order));
                order = orderRepository.saveAndFlush(order);
            }
        }
    }
}
