package com.cece.alex.pos.pos.hex.order;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PriceClient priceClient;
    private OrderRepository orderRepository;

    public OrderService(PriceClient priceClient, OrderRepository orderRepository) {
        this.priceClient = priceClient;
        this.orderRepository = orderRepository;
    }

    public void addItemToOrder(int orderId, Item item){
        double price = priceClient.getPrice(item.getItemName(), item.getQuantity());

        orderRepository.save(new OrderItem(orderId, item.getItemName(), item.getQuantity(), price));
    }
}
