package com.cece.alex.order.service;

import com.cece.alex.order.interfaces.*;

public class OrderServiceImpl implements OrderService {

    private PriceClient priceClient;
    private OrderRepository orderRepository;

    public OrderServiceImpl(PriceClient priceClient, OrderRepository orderRepository) {
        this.priceClient = priceClient;
        this.orderRepository = orderRepository;
    }

    public void addItemToOrder(int orderId, Item item){
        double price = priceClient.getPrice(item.getItemName(), item.getQuantity());

        orderRepository.save(new OrderItem(orderId, item.getItemName(), item.getQuantity(), price));
    }
}
