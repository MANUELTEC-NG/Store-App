package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

import java.util.ArrayList;
import java.util.List;

public  class ProductCatalogue {

   private static ArrayList<Biscuit> biscuitsCatalogue;
   private static ArrayList<Gala> galaCatalogue;
    Biscuit biscuit;

    public ProductCatalogue(){
       biscuitsCatalogue = new ArrayList<>(15);
       galaCatalogue = new ArrayList<>(10);

        populateProductList("Biscuit");
        populateProductList("Gala");
        System.out.println(biscuitsCatalogue.get(0));
        System.out.println("Called");
    }

    private void populateProductList(String type){

        //type.equals("Biscuit"))
        if ( true) {

        for (int i = 1; i <= 10; i++) {
            Biscuit mBiscuit = new Biscuit("AAAA", 50, "Sweetning",
                    "Snacks", 2020, 100);
            biscuitsCatalogue.add(mBiscuit);
        }

        /*if (type.equals("Gala"))*/
        } else {
            for (int i = 1; i <= 10; i++) {
                Gala mGala = new Gala ("Rite",70 ,"Rite Plc", "Snacks", 2022, 100001);
                galaCatalogue.add(mGala);
            }
        }
    }

    public static ArrayList<Biscuit> getCatalogue(String catalogueName){
        String catalName = catalogueName.toLowerCase();

        switch (catalName){
            case "biscuit":
                return biscuitsCatalogue;
            case  "gala":
                //return galaCatalogue;

        }
        return biscuitsCatalogue;
    }
//    public static ArrayList<Gala> getGalaCatalogue(){
//        return galaCatalogue;
//    }
}
