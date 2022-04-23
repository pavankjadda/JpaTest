package com.pj.jpatest.web;

import com.pj.jpatest.domain.Order;
import com.pj.jpatest.domain.OrderItem;
import com.pj.jpatest.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/create")
    public Order create() {
        var order = new Order();
        var orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("iPhone", order));
        orderItems.add(new OrderItem("Pixel", order));

        order.setOrderItems(orderItems);
        return orderRepository.saveAndFlush(order);
    }
}
