package com.cece.alex.pos;

import com.cece.alex.order.interfaces.RepositoryPort;
import com.cece.alex.order.interfaces.OrderPort;
import com.cece.alex.order.interfaces.PricePort;
import com.cece.alex.pos.checkout.adapters.CheckoutRepositoryImpl;
import com.cece.alex.pos.checkout.interfaces.CheckoutRepository;
import com.cece.alex.pos.checkout.interfaces.CheckoutService;
import com.cece.alex.pos.checkout.interfaces.SubtotalService;
import com.cece.alex.pos.checkout.interfaces.TaxService;
import com.cece.alex.pos.checkout.service.CheckoutServiceImpl;
import com.cece.alex.pos.checkout.service.SubtotalServiceImpl;
import com.cece.alex.pos.checkout.service.TaxServiceImpl;
import com.cece.alex.pos.order.adapters.FakeRepositoryAdapter;
import com.cece.alex.pos.order.adapters.RepositoryAdapter;
import com.cece.alex.pos.order.adapters.OrderAdapter;
import com.cece.alex.pos.order.adapters.PriceAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosDemoApplication.class, args);
    }

    @Bean
    public PricePort priceClient() {
        return new PriceAdapter();
    }

    @Profile("!fake")
    @Bean
    public RepositoryPort orderRepository() {
        return new RepositoryAdapter();
    }

    @Profile("fake")
    @Bean
    public RepositoryPort fakeOrderRepository() {
        return new FakeRepositoryAdapter();
    }

    @Bean
    @Profile("!fake")
    public OrderPort orderService(PricePort pricePort,
                                  RepositoryPort repositoryPort) {
        return new OrderAdapter(pricePort, repositoryPort);
    }


    @Bean
    @Profile("fake")
    public OrderPort fakeOrderService(PricePort pricePort,
                                      RepositoryPort fakeRepositoryPort) {
        return new OrderAdapter(pricePort, fakeRepositoryPort);
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
