package com.manuel.decadev.model.ProductCataloque;

import java.util.ArrayList;

public  class ProductCatalogue {

   private static ArrayList<Biscuit> biscuitsCatalogue = new ArrayList<>();
   private static ArrayList<Gala> galaCatalogue = new ArrayList<>();
    Biscuit biscuit;

    private ProductCatalogue(){

    }

    static private void populateProductList(String type){


        if ( type.toLowerCase().equals("biscuit") ) {

        for (int i = 1; i <= 10; i++) {
            Biscuit mBiscuit = new Biscuit("Cabin".toLowerCase(), 50, "Sweetning",
                    "Snacks", 2020, 100);
            biscuitsCatalogue.add(mBiscuit);
        }


        } else if (type.equals("gala")) {
            for (int i = 1; i <= 10; i++) {
                Gala mGala = new Gala ("Rite",70 ,"Rite Plc", "Snacks", 2022, 100001);
                galaCatalogue.add(mGala);
            }
        }
    }

    public static ArrayList<Biscuit> getProductCatalogue(String catalogueName){
        String catalName = catalogueName.toLowerCase();
        // TODO
        // This needs reworking

        populateProductList(catalogueName);

        if ("biscuit".equals(catalName)) {
            return biscuitsCatalogue;
        } else if ("gala".equals(catalName)) {
            //return galaCatalogue;
        }
        return biscuitsCatalogue;
    }

}
