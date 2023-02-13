package com.pj.jpatest.web;

import com.pj.jpatest.domain.Order;
import com.pj.jpatest.domain.OrderItem;
import com.pj.jpatest.repository.OrderItemRepository;
import com.pj.jpatest.repository.OrderRepository;
import com.pj.jpatest.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Provides a REST API for the Orders
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final OrderItemRepository orderItemRepository;

    public OrderController(OrderRepository orderRepository, OrderService orderService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.orderItemRepository = orderItemRepository;
    }

    /**
     * Create a new order and persist it to the database.
     *
     * @return the newly created order
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
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
        order = orderRepository.saveAndFlush(order);
        System.out.println("Time after order save:" + LocalDateTime.now());

        var items = order.getOrderItems();
        System.out.println("Time before same items order save:" + LocalDateTime.now());
        items.add(new OrderItem("iPhone 8", order));
        order.getOrderItems().addAll(items);
        order = orderRepository.saveAndFlush(order);
        System.out.println("Time after same items  order save:" + LocalDateTime.now());
        return order;
    }

    @GetMapping("/save")
    public void save() {
        orderService.save();
    }
}
