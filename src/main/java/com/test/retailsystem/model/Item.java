package com.test.retailsystem.model;

public class Item {

    private String code;
    private double price;
    private boolean isGrocery;

    public Item(String code, double price, boolean isGrocery) {
        this.code = code;
        this.price = price;
        this.isGrocery = isGrocery;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGrocery() {
        return isGrocery;
    }

    public void setGrocery(boolean grocery) {
        isGrocery = grocery;
    }

}
