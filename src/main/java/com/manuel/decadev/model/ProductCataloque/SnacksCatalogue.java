package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

import java.util.ArrayList;

public class SnacksCatalogue {

    static private double totalPrice = 0;

    static private int totalPretzelQty = 0;

    public static ArrayList<Product> pretzelCatalogue = new ArrayList<>() ;

    private SnacksCatalogue(){}

    public static double getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(double totalPrice) {
        SnacksCatalogue.totalPrice = totalPrice;
    }

    public static int getTotalPretzelQty() {
        return totalPretzelQty;
    }

    public static void setTotalPretzelQty(int totalPretzelQty) {
        SnacksCatalogue.totalPretzelQty = totalPretzelQty;
    }

    public static ArrayList<Product> getPretzelCatalogue() {
        return pretzelCatalogue;
    }

    public static void setPretzelCatalogue(ArrayList<Product> pretzelCatalogue) {
        SnacksCatalogue.pretzelCatalogue = pretzelCatalogue;
    }





}
