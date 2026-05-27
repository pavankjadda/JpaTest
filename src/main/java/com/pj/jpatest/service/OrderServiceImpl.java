package com.pj.jpatest.service;

import com.pj.jpatest.domain.Order;
import com.pj.jpatest.domain.OrderItem;
import com.pj.jpatest.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Create a new order and persist it to the database.
     *
     * @return the newly created order
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public Order create() {
        var order = new Order();
        var orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("iPhone 14", order));
        orderItems.add(new OrderItem("Pixel 7", order));
        orderItems.add(new OrderItem("Pixel 6a", order));
        orderItems.add(new OrderItem("Pixel 6", order));
        orderItems.add(new OrderItem("Pixel 5", order));
        orderItems.add(new OrderItem("iPhone 13 ", order));
        orderItems.add(new OrderItem("iPhone 12", order));
        orderItems.add(new OrderItem("iPhone 11", order));
        orderItems.add(new OrderItem("iPhone 10", order));
        order.setOrderItems(orderItems);
        System.out.println("Time before order save:" + LocalDateTime.now());
        order = repository.save(order);
        System.out.println("Time after order save:" + LocalDateTime.now());

        System.out.println("Time before same items order save:" + LocalDateTime.now());
        order.getOrderItems().add(new OrderItem("iPhone 8", order));
        order = repository.save(order);
        System.out.println("Time after same items  order save:" + LocalDateTime.now());
        return order;
    }

    @Override
    public void save() {
        var order = repository.findById(2L).orElse(null);
        if (order != null) {
            if (order.getOrderItems().stream().anyMatch(oi -> oi.getName().equals("iPhone 15"))) {
                System.out.println("iPhone 15 present, hence skipping it");
            } else {
                order.getOrderItems().add(new OrderItem("iPhone 15", order));
                repository.save(order);
            }
        }
    }
}