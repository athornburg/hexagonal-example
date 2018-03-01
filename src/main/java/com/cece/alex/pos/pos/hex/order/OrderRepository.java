package com.cece.alex.pos.pos.hex.order;

import org.springframework.stereotype.Component;

@Component
public class OrderRepository {

    public void save(OrderItem orderItem) {
        System.out.println("Saved item in database: " + orderItem.toString());
    }
}
