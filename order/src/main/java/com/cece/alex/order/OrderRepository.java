package com.cece.alex.order;

import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    public void save(OrderItem orderItem) {
        System.out.println("Saved item in database: " + orderItem.toString());
    }
}
