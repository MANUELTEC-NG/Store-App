package com.manuel.decadev.model;

public abstract class Item {
   protected String category = "";
    protected int manufacturingDate = 0;
    protected String manufacturer = "";
    protected double price = 0;

public Item(double price, String productCategory){
    this.category = productCategory;
    this.price = price;
}

    public abstract boolean hasPositiveBrandReview();


    public void setManufacturingDate(int manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


}
