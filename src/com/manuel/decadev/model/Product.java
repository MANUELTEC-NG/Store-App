package com.manuel.decadev.model;

public abstract class Product {
   protected String category = "";
    protected int manufacturingDate = 0;
    protected String manufacturer = "";
    protected int price = 0;

public Product(int price, String manufacturer, int manufacturingDate, String category){
    this.category = category;
    this.manufacturingDate = manufacturingDate;
    this.manufacturer = manufacturer;
    this.price = price;
}

    public abstract boolean hasPositiveBrandReview();



}
