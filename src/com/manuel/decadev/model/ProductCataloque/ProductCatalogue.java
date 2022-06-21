package com.manuel.decadev.model.ProductCataloque;

import java.util.ArrayList;

 public  class ProductCatalogue {

   private static ArrayList<Biscuit> biscuitsCatalogue;
   private static ArrayList<Gala> galaCatalogue;
    Biscuit biscuit;

    private ProductCatalogue(){
       biscuitsCatalogue = new ArrayList<>(15);
       galaCatalogue = new ArrayList<>(10);
        populateProductList("Biscuit");
        populateProductList("Gala");
    }

    private void populateProductList(String type){

        if (type.equals("Biscuit")){

        for (int i = 1; i <= 10; i++) {
            Biscuit mBiscuit = new Biscuit("AAAA", "uk", "Sweetning",
                    1234, 2020, 100);
            biscuitsCatalogue.add(mBiscuit);
        }

        } else if (type.equals("Gala")){
            for (int i = 1; i <= 10; i++) {
                Gala mGala = new Gala ("Rite", "Rite LLC","Snacks",
                        2022, 1001);
                galaCatalogue.add(mGala);
            }
        }
    }

    public static ArrayList<Biscuit> getBiscuitsCatalogue(){

        return biscuitsCatalogue;
    }
    public static ArrayList<Gala> getGalaCatalogue(){
        return galaCatalogue;
    }
}
