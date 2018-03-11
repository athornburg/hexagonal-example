package com.cece.alex.pos.checkout.endpoint;


import com.cece.alex.pos.checkout.interfaces.CheckoutService;
import com.cece.alex.pos.checkout.interfaces.FinalOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

    private MockMvc mockMvc;

    private CheckoutController checkoutController;

    @Mock
    private CheckoutService mockCheckoutService;

    @Before
    public void setUp() {
        checkoutController = new CheckoutController(mockCheckoutService);

        mockMvc = MockMvcBuilders.standaloneSetup(checkoutController).build();
    }

    @Test
    public void tallyTotal() throws Exception {
        FinalOrder expectedOrderTotal = new FinalOrder(emptyList(), 100.5, 200.8);

        Mockito.when(mockCheckoutService.getTotal(any())).thenReturn(expectedOrderTotal);

        String response = mockMvc.perform(get("/orders/1/total"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();



        Mockito.verify(mockCheckoutService).getTotal(1);
        assertThat(new ObjectMapper().readValue(response, FinalOrder.class));
        assertThat(new ObjectMapper().readValue(response, FinalOrder.class))
                .isEqualTo(expectedOrderTotal);
    }
}