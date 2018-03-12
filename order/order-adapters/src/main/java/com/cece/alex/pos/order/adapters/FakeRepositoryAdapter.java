package com.cece.alex.pos.order.adapters;

import com.cece.alex.order.interfaces.OrderItem;
import com.cece.alex.order.interfaces.RepositoryPort;

public class FakeRepositoryAdapter implements RepositoryPort {

    public void save(OrderItem orderItem) {
        System.out.println("I'm pretending to saved an item in database: " + orderItem.toString());
    }
}
