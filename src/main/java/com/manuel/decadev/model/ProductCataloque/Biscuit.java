package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

public class Biscuit extends Product {


    private  int serialNo;
    private  String productNAme;
    private int expiryDate = 0;
    private static int purchaseCount = 0;


    public Biscuit (String productNAme, int price, String manufacturer, String productCategory,
                    int manufacturingDate, int expiryDate){

        super(price, manufacturer,manufacturingDate, productCategory);
        this.productNAme = productNAme;
        this.serialNo = serialNo;
        this.expiryDate = expiryDate;

        purchaseCount += 1;
    }



    @Override
    public boolean hasPositiveBrandReview() {
        return false;
    }

    public String getProductNAme() {
        return productNAme;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setProductNAme(String productNAme) {
        this.productNAme = productNAme;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static int getPurchaseCount() {
        return purchaseCount;
    }

    public static void setPurchaseCount(int purchaseCount) {
        Biscuit.purchaseCount = purchaseCount;
    }

}
