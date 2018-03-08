package com.cece.alex.pos.checkout;

import java.util.List;

public class FinalOrder {

    private List<OrderItem> orderItems;
    private Double subTotal;
    private Double total;

    public FinalOrder() { }

    public FinalOrder(List<OrderItem> orderItems, Double subTotal, Double total) {
        this.orderItems = orderItems;
        this.subTotal = subTotal;
        this.total = total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinalOrder that = (FinalOrder) o;

        if (orderItems != null ? !orderItems.equals(that.orderItems) : that.orderItems != null) return false;
        if (subTotal != null ? !subTotal.equals(that.subTotal) : that.subTotal != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = orderItems != null ? orderItems.hashCode() : 0;
        result = 31 * result + (subTotal != null ? subTotal.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FinalOrder{" +
                "orderItems=" + orderItems +
                ", subTotal=" + subTotal +
                ", total=" + total +
                '}';
    }
}
