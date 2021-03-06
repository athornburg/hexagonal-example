package com.cece.alex.pos.checkout.service;

import com.cece.alex.pos.checkout.interfaces.CheckoutRepository;
import com.cece.alex.pos.checkout.interfaces.FinalOrder;
import com.cece.alex.pos.checkout.interfaces.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    private CheckoutRepository mockCheckoutRepository;

    @Mock
    private SubtotalServiceImpl mockSubtotalService;

    @Mock
    private TaxServiceImpl mockTaxService;

    @Mock
    private CheckoutServiceImpl checkoutService;

    @Before
    public void setUp() throws Exception {
        checkoutService = new CheckoutServiceImpl(mockCheckoutRepository, mockSubtotalService, mockTaxService);
    }

    @Test
    public void getAllItemsAndSubtotal() throws Exception {
        List<OrderItem> items = singletonList(new OrderItem(1, "item name", 2, 20.5));
        when(mockCheckoutRepository.getOrderItems(1)).thenReturn(items);
        when(mockSubtotalService.calculateSubtotal(items)).thenReturn(100.5);
        when(mockTaxService.calculateTax(any())).thenReturn(20.5);

        FinalOrder finalOrder = checkoutService.getTotal(1);

        verify(mockCheckoutRepository).getOrderItems(1);
        verify(mockSubtotalService).calculateSubtotal(items);
        verify(mockTaxService).calculateTax(100.5);
        assertThat(finalOrder).isEqualTo(new FinalOrder(items, 100.5, 121.0));
    }

}