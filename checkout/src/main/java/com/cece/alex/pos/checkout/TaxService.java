package com.cece.alex.pos.checkout;

import org.springframework.stereotype.Component;

@Component
public class TaxService {
    public Double calculateTax(Double subtotal) {
        return 20.5;
    }
}
