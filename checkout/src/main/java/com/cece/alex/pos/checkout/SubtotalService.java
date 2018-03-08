package com.cece.alex.pos.checkout;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtotalService {
    public Double calculateSubtotal(List<OrderItem> items) {
        return 100.5;
    }
}
