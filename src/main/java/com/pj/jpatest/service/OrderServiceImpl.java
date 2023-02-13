package com.pj.jpatest.service;

import com.pj.jpatest.domain.OrderItem;
import com.pj.jpatest.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WorkerThread workerThread;

    public OrderServiceImpl(OrderRepository orderRepository, WorkerThread workerThread) {
        this.orderRepository = orderRepository;
        this.workerThread = workerThread;
    }

    @Override
    public void save() {
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
