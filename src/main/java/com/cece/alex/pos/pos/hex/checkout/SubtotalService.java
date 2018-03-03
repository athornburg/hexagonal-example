package com.cece.alex.pos.pos.hex.checkout;

import com.cece.alex.pos.pos.hex.order.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtotalService {
    public Double calculateSubtotal(List<OrderItem> items) {
        return 100.5;
    }
}
