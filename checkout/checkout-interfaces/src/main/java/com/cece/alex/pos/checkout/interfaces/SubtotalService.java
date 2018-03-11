package com.cece.alex.pos.checkout.interfaces;

import java.util.List;

public interface SubtotalService {
    public Double calculateSubtotal(List<OrderItem> items);
}
