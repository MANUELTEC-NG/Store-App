package com.manuel.decadev.model.ProductCataloque;


import com.manuel.decadev.model.Product;

import java.util.ArrayList;

public class BarsCatalogue  {
    static private double totalPrice = 0;

    static private int totalCarrotQty = 0;
    static private  int totalBranQuantity = 0;
    static private int totalBananaQty = 0;

    public static int getTotalCarrotQty() {
        return totalCarrotQty;
    }

    public static void setTotalCarrotQty(int totalCarrotQty) {
        BarsCatalogue.totalCarrotQty = totalCarrotQty;
    }

    public static int getTotalBranQuantity() {
        return totalBranQuantity;
    }

    public static void setTotalBranQuantity(int totalBranQuantity) {
        BarsCatalogue.totalBranQuantity = totalBranQuantity;
    }

    public static int getTotalBananaQty() {
        return totalBananaQty;
    }

    public static void setTotalBananaQty(int totalBananaQty) {
        BarsCatalogue.totalBananaQty = totalBananaQty;
    }

    public static ArrayList<Product> getCarrotCatalogue() {
        return carrotCatalogue;
    }

    public static void setCarrotCatalogue(ArrayList<Product> carrotCatalogue) {
        BarsCatalogue.carrotCatalogue = carrotCatalogue;
    }

    public static ArrayList<Product> getBranCatalogue() {
        return branCatalogue;
    }

    public static void setBranCatalogue(ArrayList<Product> branCatalogue) {
        BarsCatalogue.branCatalogue = branCatalogue;
    }

    public static ArrayList<Product> getBananaCatalogue() {
        return bananaCatalogue;
    }

    public static void setBananaCatalogue(ArrayList<Product> bananaCatalogue) {
        BarsCatalogue.bananaCatalogue = bananaCatalogue;
    }

    public   static ArrayList<Product> carrotCatalogue = new ArrayList<>() ;
    public static ArrayList<Product> branCatalogue = new ArrayList<>();
    public   static ArrayList<Product> bananaCatalogue = new ArrayList<>();

    private BarsCatalogue(){

    }


    public static double getTotalPrice() {
        return totalPrice;
    }






    public static void setTotalPrice(double totalPrice) {
        BarsCatalogue.totalPrice = totalPrice;
    }



    public static int isSameThing(){

        return carrotCatalogue.size();
    }

}
