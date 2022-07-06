package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Item;
import com.manuel.decadev.model.Product;

import java.util.ArrayList;

 public  class CookieCatalogue {
   static private double totalPrice = 0;

   static private int totalChocoQty = 0;
   static private  int totalOatQuantity = 0;
   static private int totalArrowRootQty = 0;



 public   static ArrayList<Product>  chocoCatalogue = new ArrayList<>() ;
   public static ArrayList<Product> oatCatalogue = new ArrayList<>();
  public   static ArrayList<Product> arrowRootCatalogue = new ArrayList<>();

    private CookieCatalogue(){


    }




     public static double getTotalPrice() {
        return totalPrice;
    }

    public static int getTotalChocoQty() {
        return totalChocoQty;
    }

    public static int getTotalOatQuantity() {
        return totalOatQuantity;
    }

    public static int getTotalArrowRootQty() {
        return totalArrowRootQty;
    }


    public static ArrayList<Product> getChocoCatalogue() {
        return chocoCatalogue;
    }

    public static ArrayList<Product> getOatCatalogue() {
        return oatCatalogue;
    }

    public static ArrayList<Product> getArrowRootCatalogue() {
        return arrowRootCatalogue;
    }

    public static void setTotalPrice(double totalPrice) {
        CookieCatalogue.totalPrice = totalPrice;
    }

    public static void setTotalChocoQty(int totalChocoQty) {
        CookieCatalogue.totalChocoQty = totalChocoQty;
    }

    public static void setTotalOatQuantity(int totalOatQuantity) {
        CookieCatalogue.totalOatQuantity = totalOatQuantity;
    }

    public static void setTotalArrowRootQty(int totalArrowRootQty) {
        CookieCatalogue.totalArrowRootQty = totalArrowRootQty;
    }

    public static int isSameThing(){

        return chocoCatalogue.size();
    }
}
