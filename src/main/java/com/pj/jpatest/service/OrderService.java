package com.pj.jpatest.service;

import com.pj.jpatest.domain.Order;

public interface OrderService {
    Order save();

    /**
     * Create a new order and persist it to the database.
     *
     * @return the newly created order
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Order create();
}