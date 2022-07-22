package com.manuel.decadev.model;


import java.util.Comparator;
import java.util.Objects;

public class Product extends Item implements Comparator<Product> {

    private double price = 0;
    private String name;
    private  int qty = 0;


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

    public  int getQty() {
        return qty;
    }

    public  void setQty(int quantity) {
        this.qty = quantity;
    }

    public void setCategoryName(String categoryName){
        super.category = categoryName;
    }


    @Override
    public int compare(Product p1, Product p2) {

        int quantity1 = p1.getQty();
        int quantity2 = p2.getQty();

        if (quantity1 > quantity2){
            return  -1;
        } else if (quantity1 < quantity2){
            return 1;
        } else {
            return  0;
        }

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
