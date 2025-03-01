package com.pj.jpatest.service;

import com.pj.jpatest.domain.Order;

public interface OrderService {
    Order create();

    void save();
}