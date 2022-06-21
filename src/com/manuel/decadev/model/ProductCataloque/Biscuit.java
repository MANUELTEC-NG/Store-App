package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

public class Biscuit extends Product {


    private  int serialNo;
    private  String productNAme;
    private int expiryDate = 0;
    private static int purchaseCount = 0;


    public Biscuit ( String productNAme, String manufacturer, String category,
                     int expiryDate, int manufacturingDate,
                  int serialNo ){

        super(manufacturer,manufacturingDate, category);
        this.productNAme = productNAme;
        this.serialNo = serialNo;
        this.expiryDate = expiryDate;

        purchaseCount += 1;

    }

    @Override
    public boolean hasPositiveBrandReview() {
        return false;
    }
}
