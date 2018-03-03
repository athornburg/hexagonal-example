package com.cece.alex.pos.pos.hex.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private PriceClient mockPriceClient;

    @Mock
    private OrderRepository mockOrderRepository;

    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderService(mockPriceClient, mockOrderRepository);
    }

    @Test
    public void shouldLookupPriceOfItemAndSave() {
        when(mockPriceClient.getPrice(anyString(), anyInt())).thenReturn(50.0);
        orderService.addItemToOrder(1, new Item("cool thing", 3));

        verify(mockPriceClient).getPrice("cool thing", 3);
        verify(mockOrderRepository).save(new OrderItem(1, "cool thing", 3, 50.0));
    }
}