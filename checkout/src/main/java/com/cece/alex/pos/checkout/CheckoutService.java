package com.cece.alex.pos.checkout;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    private SubtotalService subtotalService;
    private TaxService taxService;

    public CheckoutService(CheckoutRepository checkoutRepository, SubtotalService subtotalService, TaxService taxService) {
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
