package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

import java.util.ArrayList;

public class CrackersCatalogue {


    static private double totalPrice = 0;
    static private int totalWholeWheatQty = 0;
    static private  int totalPotatoChipQty = 0;

    public static ArrayList<Product> wholeWheatCatalogue = new ArrayList<>();
    public static ArrayList<Product> potatoChipCatalogue = new ArrayList<>();

    private CrackersCatalogue(){}


    public static double getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(double totalPrice) {
        CrackersCatalogue.totalPrice = totalPrice;
    }

    public static int getTotalWholeWheatQty() {
        return totalWholeWheatQty;
    }

    public static void setTotalWholeWheatQty(int totalWholeWheatQty) {
        CrackersCatalogue.totalWholeWheatQty = totalWholeWheatQty;
    }

    public static int getTotalPotatoChipQty() {
        return totalPotatoChipQty;
    }

    public static void setTotalPotatoChipQty(int totalPotatoChipQty) {
        CrackersCatalogue.totalPotatoChipQty = totalPotatoChipQty;
    }

    public static ArrayList<Product> getWholeWheatCatalogue() {
        return wholeWheatCatalogue;
    }

    public static void setWholeWheatCatalogue(ArrayList<Product> wholeWheatCatalogue) {
        CrackersCatalogue.wholeWheatCatalogue = wholeWheatCatalogue;
    }

    public static ArrayList<Product> getPotatoChipCatalogue() {
        return potatoChipCatalogue;
    }

    public static void setPotatoChipCatalogue(ArrayList<Product> potatoChipCatalogue) {
        CrackersCatalogue.potatoChipCatalogue = potatoChipCatalogue;
    }

}
