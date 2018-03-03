package com.cece.alex.pos.pos.hex.checkout;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

    private MockMvc mockMvc;

    private CheckoutController checkoutController;

    @Mock
    private CheckoutService mockCheckoutService;

    @Before
    public void setUp() throws Exception {
        checkoutController = new CheckoutController(mockCheckoutService);

        mockMvc = MockMvcBuilders.standaloneSetup(checkoutController).build();
    }

    @Test
    public void tallyTotal() throws Exception {
        FinalOrder expectedOrderTotal = new FinalOrder(emptyList(), 100.5, 200.8);

        when(mockCheckoutService.getTotal(any())).thenReturn(expectedOrderTotal);

        String response = mockMvc.perform(get("/orders/1/total"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        verify(mockCheckoutService).getTotal(1);
        assertThat(new ObjectMapper().readValue(response, FinalOrder.class))
                .isEqualTo(expectedOrderTotal);
    }
}