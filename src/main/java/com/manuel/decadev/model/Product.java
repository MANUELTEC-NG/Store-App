package com.manuel.decadev.model;


public class Product extends Item {

    public double price = 0;
    public String productName;


    public Product(int price, String productName, String manufacturer, int manufacturingDate, String productCategory) {
        super(price, manufacturer, manufacturingDate, productCategory);
        this.price = price;
        this.productName = productName;
    }

    @Override
    public boolean hasPositiveBrandReview() {
        return false;
    }
}
