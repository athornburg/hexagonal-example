package com.cece.alex.pos.pos.hex.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private OrderService mockOrderService;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        OrderController orderController = new OrderController(mockOrderService);

        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void shouldScanAnOrderAndSendToService() throws Exception{
        mockMvc.perform(post("/order/1/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "  \"itemName\" : \"coffee\",\n" +
                "  \"quantity\": 2\n" +
                "}")).andExpect(status().isOk());

        verify(mockOrderService).addItemToOrder(1, new Item("coffee", 2));
    }
}