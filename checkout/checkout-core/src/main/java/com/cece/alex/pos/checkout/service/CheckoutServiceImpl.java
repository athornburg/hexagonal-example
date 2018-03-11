package com.cece.alex.pos.checkout.service;

import com.cece.alex.pos.checkout.interfaces.*;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {

    private CheckoutRepository checkoutRepository;
    private SubtotalService subtotalService;
    private TaxService taxService;

    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, SubtotalService subtotalService, TaxService
            taxService) {
        this.checkoutRepository = checkoutRepository;
        this.subtotalService = subtotalService;
        this.taxService = taxService;
    }

    public FinalOrder getTotal(Integer orderId) {
        List<OrderItem> items = checkoutRepository.getOrderItems(orderId);
        Double subtotal = subtotalService.calculateSubtotal(items);
        Double totalTax = taxService.calculateTax(subtotal);

        double total = subtotal + totalTax;
        return new FinalOrder(items, subtotal, total);
    }
}
