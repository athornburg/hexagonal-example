package com.cece.alex.pos;

import com.cece.alex.order.interfaces.OrderRepository;
import com.cece.alex.order.interfaces.OrderService;
import com.cece.alex.order.interfaces.PriceClient;
import com.cece.alex.order.service.OrderServiceImpl;
import com.cece.alex.pos.checkout.adapters.CheckoutRepositoryImpl;
import com.cece.alex.pos.checkout.interfaces.CheckoutRepository;
import com.cece.alex.pos.checkout.interfaces.CheckoutService;
import com.cece.alex.pos.checkout.interfaces.SubtotalService;
import com.cece.alex.pos.checkout.interfaces.TaxService;
import com.cece.alex.pos.checkout.service.CheckoutServiceImpl;
import com.cece.alex.pos.checkout.service.SubtotalServiceImpl;
import com.cece.alex.pos.checkout.service.TaxServiceImpl;
import com.cece.alex.pos.order.adapters.OrderRepositoryImpl;
import com.cece.alex.pos.order.adapters.PriceClientImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosDemoApplication.class, args);
    }

    @Bean
    public PriceClient priceClient() {
        return new PriceClientImpl();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepositoryImpl();
    }

    @Bean
    public OrderService orderService(PriceClient priceClient, OrderRepository orderRepository) {
        return new OrderServiceImpl(priceClient, orderRepository);
    }


    @Bean
    public CheckoutRepository checkoutRepository() {
        return new CheckoutRepositoryImpl();
    }

    @Bean
    public TaxService taxService() {
        return new TaxServiceImpl();
    }

    @Bean
    public SubtotalService subtotalService() {
        return new SubtotalServiceImpl();
    }

    @Bean
    public CheckoutService checkoutService(CheckoutRepository checkoutRepository, SubtotalService subtotalService,
                                           TaxService taxService) {
        return new CheckoutServiceImpl(checkoutRepository, subtotalService, taxService);
    }
}
