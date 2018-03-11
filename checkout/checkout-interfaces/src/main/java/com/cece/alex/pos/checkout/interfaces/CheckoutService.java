package com.cece.alex.pos.checkout.interfaces;

public interface CheckoutService {
    public FinalOrder getTotal(Integer orderId);
}
