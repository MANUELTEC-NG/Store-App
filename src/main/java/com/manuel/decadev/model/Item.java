package com.manuel.decadev.model;

public abstract class Item {
   protected String category = "";
    protected int manufacturingDate = 0;
    protected String manufacturer = "";
    protected int price = 0;

public Item(int price, String manufacturer, int manufacturingDate, String productCategory){
    this.category = category;
    this.manufacturingDate = manufacturingDate;
    this.manufacturer = manufacturer;
    this.price = price;
}

    public abstract boolean hasPositiveBrandReview();



}
