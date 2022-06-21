package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

public class Gala extends Product {


     private String productNAme;
    private int serialNo;
    private String manufacturer;
    private int expiryDate = 0;
    private static int purchaseCount = 0;


    public Gala( String productNAme,String manufacturer, String category, int manufacturingDate
                 , int serialNo ){

        super(manufacturer, manufacturingDate, category);

        this.productNAme = productNAme;
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;

        purchaseCount += 1;

    }

    public  boolean hasPositiveBrandReview(){

        return true;
    };

    public  int checkExpiry(Product p){

        return 0;
    }


}
