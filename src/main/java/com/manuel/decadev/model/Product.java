package com.manuel.decadev.model;


import java.util.Objects;

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

    public String getManufacturerName(){

        return super.manufacturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) != 0 &&
                productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, productName);
    }
}
