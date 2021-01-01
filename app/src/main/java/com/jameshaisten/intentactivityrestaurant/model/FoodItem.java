package com.jameshaisten.intentactivityrestaurant.model;

import java.io.Serializable;

public class FoodItem implements Serializable {

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public FoodItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }




}// End FoodItem
