package com.cece.alex.pos.order.adapters;

import com.cece.alex.order.interfaces.OrderItem;
import com.cece.alex.order.interfaces.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

    public void save(OrderItem orderItem) {
        System.out.println("Saved item in database: " + orderItem.toString());
    }
}
