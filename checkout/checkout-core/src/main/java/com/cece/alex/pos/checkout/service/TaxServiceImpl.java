package com.cece.alex.pos.checkout.service;

import com.cece.alex.pos.checkout.interfaces.TaxService;

public class TaxServiceImpl implements TaxService {
    public Double calculateTax(Double subtotal) {
        return 20.5;
    }
}
