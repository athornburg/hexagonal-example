package com.cece.alex.pos.checkout.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;

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
        FinalOrder expectedOrderTotal = new FinalOrder(Lists.emptyList(), 100.5, 200.8);

        Mockito.when(mockCheckoutService.getTotal(ArgumentMatchers.any())).thenReturn(expectedOrderTotal);

        String response = mockMvc.perform(MockMvcRequestBuilders.get("/orders/1/total"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();


        Mockito.verify(mockCheckoutService).getTotal(1);
        Assertions.assertThat(new ObjectMapper().readValue(response, FinalOrder.class))
                .isEqualTo(expectedOrderTotal);
    }
}