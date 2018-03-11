package com.cece.alex.pos.checkout.interfaces;

import java.util.List;

public interface CheckoutRepository {
    public List<OrderItem> getOrderItems(int orderId);
}
