package com.manuel.decadev.model;


import java.util.Objects;

public class Product extends Item {

    public double price = 0;
    public String name;


    public Product(int price, String name, String productCategory) {
        super(price,  productCategory.toLowerCase());
        this.price = price;
        this.name = name.toLowerCase();
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
        return Double.compare(product.price, this.price) != 0 &&
                this.name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
