package com.guenther.spring2.util;

/**
 * Created by DELL on 8/14/2017.
 */
public class Items {
    private String name;
    private String description;
    private int quantity;
    private float price;

    public Items(String name, String description, int quantity, float price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Items() {
        name = "";
        description = "";
        quantity = 0;
        price = 0;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
