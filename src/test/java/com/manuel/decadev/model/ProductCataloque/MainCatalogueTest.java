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
       String productName = catalogue.get(catalogue.size() - 1).getName();
       Double price = catalogue.get(0).getPrice();

        int catalogueSize = catalogue.size();
        assertTrue(catalogueSize > 0);

        int index = 0;
        Product p  = null;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            assertNotNull(product);
            if (productName.equals(product.getName())){
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
        assertEquals(products.get(0).getName(), "chocolate chip");
    }

    @Test
    void partitionProductToCatalogues() throws IOException {
        //chocolateCatalogue = CookieCatalogue.getChocoCatalogue();

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

            }
        }


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
