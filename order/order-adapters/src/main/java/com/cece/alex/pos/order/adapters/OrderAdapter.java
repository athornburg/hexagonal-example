package com.cece.alex.pos.order.adapters;

import com.cece.alex.order.interfaces.*;

public class OrderAdapter implements OrderPort {

    private PricePort pricePort;
    private RepositoryPort repositoryPort;

    public OrderAdapter(PricePort pricePort, RepositoryPort repositoryPort) {
        this.pricePort = pricePort;
        this.repositoryPort = repositoryPort;
    }

    public void addItemToOrder(int orderId, Item item){
        double price = pricePort.getPrice(item.getItemName(), item.getQuantity());

        repositoryPort.save(new OrderItem(orderId, item.getItemName(), item.getQuantity(), price));
    }
}
