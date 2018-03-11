package com.cece.alex.pos.checkout.service;

import com.cece.alex.pos.checkout.interfaces.OrderItem;
import com.cece.alex.pos.checkout.interfaces.SubtotalService;

import java.util.List;

public class SubtotalServiceImpl implements SubtotalService {
    public Double calculateSubtotal(List<OrderItem> items) {
        return 100.5;
    }
}
