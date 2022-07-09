package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainCatalogueTest {
    static ArrayList<Product> chocolateCatalogue;
    static ArrayList<Product> oatmealCatalogue;
    static ArrayList<Product> arrowRootCatalogue;

    static ArrayList<Product> carrotCatalogue;
    static ArrayList<Product> branCatalogue;
    static ArrayList<Product> bananaCatalogue;

    static ArrayList<Product> pretzelsCatalogue;

    static ArrayList<Product> wholeWheatCatalogue;
    static ArrayList<Product> potatoChipsCatalogue;


    @BeforeEach
    void setUp() throws IOException {
        //MainCatalogue.partitionProductToCatalogues();
        partitionProductToCatalogues();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchingCatalogueForProductName() {
       ArrayList<Product> catalogue = findCatalogueByName("chocolate");
       String productName = catalogue.get(catalogue.size() - 1).name;
       Double price = catalogue.get(0).price;

        int catalogueSize = catalogue.size();
        assertTrue(catalogueSize > 0);

        int index = 0;
        Product p  = null;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            assertNotNull(product);
            if (productName.equals(product.name)){
                p = product;
               assertNotNull(p);
            }

            index +=1;
        }
        //assertNull(p);
    }

    @Test
    void shouldSendProdCatalogueBack() {

        ArrayList<Product> products = sendProdCatalogue();
        assertNotNull(products);
    }


    @Test
    void shouldReturnArrayOfProductCatalogue() {

        ArrayList<Product> products = findCatalogueByName("chocolate");
        assertNotNull(products);
        assertTrue(products.size() > 0);
        assertEquals(products.get(0).name, "chocolate chip");
    }

    @Test
    void partitionProductToCatalogues() throws IOException {
        chocolateCatalogue = CookieCatalogue.getChocoCatalogue();

        try (
                FileInputStream fileInputStream = new FileInputStream("/Users/dec/IdeaProjects/Store-App/src/main/java/com/manuel/decadev/resources/sampledatafoodsales.csv.csv");

                Scanner scanner = new Scanner(fileInputStream)
        ) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] productData = line.split(",");
                String categoryName = productData[3].toLowerCase().trim();
                String productName = productData[4].toLowerCase().trim();
                int productQty = Integer.parseInt(productData[5]);
                double unitPrice = Double.parseDouble(productData[6]);
                double totalPrice = Double.parseDouble(productData[7]);

                if (categoryName.equals("cookies")) {
                    if (productName.equals("chocolate chip")) {
                        chocolateCatalogue = CookieCatalogue.getChocoCatalogue();
                        Product chocolate = new Product((int) unitPrice, productName, categoryName);
                        chocolateCatalogue.add(chocolate);

                        assertTrue(chocolateCatalogue.contains(chocolate), "Product Successfully Added");

                        CookieCatalogue.setTotalChocoQty(CookieCatalogue.getTotalChocoQty() + productQty);

                        assertEquals(CookieCatalogue.getTotalChocoQty(), CookieCatalogue.getTotalChocoQty());

                    } else if (productName.equals("oatmeal raisin")) {

                        oatmealCatalogue = CookieCatalogue.getOatCatalogue();
                        Product oatmeal = new Product((int) unitPrice, productName, categoryName);
                        oatmealCatalogue.add(oatmeal);
                        CookieCatalogue.setTotalOatQuantity(CookieCatalogue.getTotalOatQuantity() + productQty);

                    } else if (productName.equals("arrowroot")) {

                        arrowRootCatalogue = CookieCatalogue.getArrowRootCatalogue();
                        Product arrowroot = new Product((int) unitPrice, productName, categoryName);
                        arrowRootCatalogue.add(arrowroot);
                        CookieCatalogue.setTotalArrowRootQty(CookieCatalogue.getTotalArrowRootQty() + productQty);

                    }

                }

                if (categoryName.equals("bars")) {
                    if (productName.equals("carrot")) {
                        carrotCatalogue = BarsCatalogue.getCarrotCatalogue();
                        Product carrot = new Product((int) unitPrice, productName, categoryName);
                        carrotCatalogue.add(carrot);

                        BarsCatalogue.setTotalCarrotQty(BarsCatalogue.getTotalCarrotQty() + productQty);

                    } else if (productName.equals("bran")) {

                        branCatalogue = BarsCatalogue.getBranCatalogue();
                        Product bran = new Product((int) unitPrice, productName, categoryName);
                        branCatalogue.add(bran);
                        BarsCatalogue.setTotalBranQuantity(BarsCatalogue.getTotalBranQuantity() + productQty);
                    } else if (productName.equals("banana")) {
                        bananaCatalogue = BarsCatalogue.getBananaCatalogue();
                        Product banana = new Product((int) unitPrice, productName, categoryName);
                        bananaCatalogue.add(banana);
                        BarsCatalogue.setTotalBananaQty(BarsCatalogue.getTotalBananaQty() + productQty);
                    }
                }

                if (categoryName.equals("snacks")) {

                    if (productName.equals("potato chips")) {

                        potatoChipsCatalogue = CrackersCatalogue.getPotatoChipCatalogue();
                        Product potato = new Product((int) unitPrice, productName, categoryName);
                        potatoChipsCatalogue.add(potato);
                        CrackersCatalogue.setTotalPotatoChipQty(CrackersCatalogue.getTotalPotatoChipQty() + productQty);
                    }


                    pretzelsCatalogue = SnacksCatalogue.getPretzelCatalogue();
                    Product pretzel = new Product((int) unitPrice, productName, categoryName);
                    pretzelsCatalogue.add(pretzel);

                    SnacksCatalogue.setTotalPretzelQty(SnacksCatalogue.getTotalPretzelQty() + productQty);


                }

                if (categoryName.equals("crackers")) {

                    if (productName.equals("whole wheat")) {

                        wholeWheatCatalogue = CrackersCatalogue.getWholeWheatCatalogue();
                        Product wheat = new Product((int) unitPrice, productName, categoryName);
                        wholeWheatCatalogue.add(wheat);
                        CrackersCatalogue.setTotalWholeWheatQty(CrackersCatalogue.getTotalWholeWheatQty() + productQty);

                    }


                }
            }
        }

        assertNotNull(chocolateCatalogue, "Its Empty");
        assertNotNull(oatmealCatalogue, "Its Empty");
        assertNotNull(wholeWheatCatalogue, "Its Empty");
        assertNotNull(bananaCatalogue, "Its Empty");
        assertNotNull(potatoChipsCatalogue, "Its Empty");
        assertNotNull(pretzelsCatalogue, "Its Empty");
        assertNotNull(carrotCatalogue, "Its Empty");
        assertNotNull(branCatalogue, "Its Empty");
        assertNotNull(arrowRootCatalogue, "Its Empty");

    }


    @Test
     ArrayList<Product> sendProdCatalogue() {
        return chocolateCatalogue;
    }


    @Test
    ArrayList<Product> findCatalogueByName(String productName) {

        String name = productName.trim().toLowerCase();
        switch (name) {

            case "chocolate":

                return chocolateCatalogue;
            case "oatmeal":
                return oatmealCatalogue;
            case "arrowroot":
                return arrowRootCatalogue;
            case "carrot":
                return carrotCatalogue;
            case "bran":
                return branCatalogue;
            case "banana":
                return bananaCatalogue;
            case "pretzel":
                return pretzelsCatalogue;
            case "wheat":
                return wholeWheatCatalogue;
            case "potato":
                return potatoChipsCatalogue;

            default:
                return new ArrayList<Product>();

        }
    }

}
