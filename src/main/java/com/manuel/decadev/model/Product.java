package com.manuel.decadev.model;


import java.util.Objects;

public class Product extends Item {

    private double price = 0;
    private String name;
    private static int totalQty = 0;


    public Product(double price, String name) {
        super(price,  "");
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getTotalQty() {
        return totalQty;
    }

    public static void setTotalQty(int totalQty) {
        Product.totalQty = totalQty;
    }

    public void setCategoryName(String categoryName){
        super.category = categoryName;
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
