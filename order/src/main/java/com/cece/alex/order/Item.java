package com.cece.alex.order;

import java.util.Objects;

@SuppressWarnings("unused")
public class Item {

    private String itemName;
    private int quantity;

    public Item() {}

    public Item(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity &&
                Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemName, quantity);
    }
}
