package com.cece.alex.pos.order.endpoint;

import com.cece.alex.order.interfaces.Item;
import com.cece.alex.order.interfaces.OrderPort;
import come.cece.alex.pos.order.endpoint.OrderController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private OrderPort mockOrderPort;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        OrderController orderController = new OrderController(mockOrderPort);

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

        verify(mockOrderPort).addItemToOrder(1, new Item("coffee", 2));
    }
}