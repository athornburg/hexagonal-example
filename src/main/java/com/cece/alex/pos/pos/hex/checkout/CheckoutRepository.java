package com.cece.alex.pos.pos.hex.checkout;

import com.cece.alex.pos.pos.hex.order.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckoutRepository {
    public List<OrderItem> getOrderItems(int orderId) {
        return null;
    }
}
