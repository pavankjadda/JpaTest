package com.pj.jpatest.web;

import com.pj.jpatest.domain.Order;
import com.pj.jpatest.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a REST API for the Orders
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * Create a new order and persist it to the database.
     *
     * @return the newly created order
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/create")
    public Order create() {
        return service.create();
    }

    @GetMapping("/save")
    public void save() {
        service.save();
    }
}