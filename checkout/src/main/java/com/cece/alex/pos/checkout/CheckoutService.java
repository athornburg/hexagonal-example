package com.cece.alex.pos.checkout;

public interface CheckoutService {
    FinalOrder getTotal(Integer orderId);
}
