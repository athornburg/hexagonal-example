package com.cece.alex.order.service;

import com.cece.alex.order.interfaces.Item;
import com.cece.alex.order.interfaces.OrderItem;
import com.cece.alex.order.interfaces.RepositoryPort;
import com.cece.alex.order.interfaces.PricePort;
import com.cece.alex.pos.order.adapters.OrderAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderPortTest {

    @Mock
    private PricePort mockPricePort;

    @Mock
    private RepositoryPort mockRepositoryPort;

    private OrderAdapter orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderAdapter(mockPricePort, mockRepositoryPort);
    }

    @Test
    public void shouldLookupPriceOfItemAndSave() {
        when(mockPricePort.getPrice(anyString(), anyInt())).thenReturn(50.0);
        orderService.addItemToOrder(1, new Item("cool thing", 3));

        verify(mockPricePort).getPrice("cool thing", 3);
        verify(mockRepositoryPort).save(new OrderItem(1, "cool thing", 3, 50.0));
    }
}