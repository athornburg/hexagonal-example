package com.cece.alex.pos.pos.hex.order;

import java.util.Objects;

public class OrderItem {
    private int orderId;
    private final String itemName;
    private final int quantity;
    private final double price;

    public OrderItem(int orderId, String itemName, int quantity, double price) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderId == orderItem.orderId &&
                quantity == orderItem.quantity &&
                Double.compare(orderItem.price, price) == 0 &&
                Objects.equals(itemName, orderItem.itemName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, itemName, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId=" + orderId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
