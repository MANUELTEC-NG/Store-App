package com.manuel.decadev.model;

public abstract class Product {
   protected String category = "";
    protected int manufacturingDate = 0;
    protected String manufacturer = "";

public Product(String manufacturer, int manufacturingDate, String category){
    this.category = category;
    this.manufacturingDate = manufacturingDate;
    this.manufacturer = manufacturer;
}

    public abstract boolean hasPositiveBrandReview();



}
