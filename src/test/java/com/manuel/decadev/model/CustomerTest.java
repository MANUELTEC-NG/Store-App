package com.manuel.decadev.model;

import com.manuel.decadev.model.ProductCataloque.MainCatalogue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static com.manuel.decadev.model.ProductCataloque.MainCatalogue.findCatalogueByName;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends Staff {

    static ArrayList<Product> chocolateCatalogue;
    static  ArrayList<Product> oatmealCatalogue;
    static ArrayList<Product> arrowRootCatalogue;

    static ArrayList<Product> carrotCatalogue;
    static  ArrayList<Product> branCatalogue;
    static ArrayList<Product> bananaCatalogue;

    static ArrayList<Product> pretzelsCatalogue;

    static  ArrayList<Product> wholeWheatCatalogue ;
    static ArrayList<Product> potatoChipsCatalogue;

    @BeforeEach
    void setUp() throws IOException {
        MainCatalogue.partitionProductToCatalogues();
        chocolateCatalogue = MainCatalogue.findCatalogueByName("Chocolate");
        oatmealCatalogue = MainCatalogue.findCatalogueByName("oat meal");
        arrowRootCatalogue = MainCatalogue.findCatalogueByName("arrow root");
        carrotCatalogue = MainCatalogue.findCatalogueByName("carrot");
        branCatalogue = MainCatalogue.findCatalogueByName("bran");
        bananaCatalogue = MainCatalogue.findCatalogueByName("banana");
        pretzelsCatalogue = MainCatalogue.findCatalogueByName("pretzel");
        wholeWheatCatalogue = MainCatalogue.findCatalogueByName("whole wheat");
        potatoChipsCatalogue = MainCatalogue.findCatalogueByName("potato");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetFirstName() {
        fail("Not Implemented yet");

    }

    @Test
    void testGetLastName() {
        fail("Not Implemented yet");

    }

    @Test
    void purchaseProduct() {
        fail("Not Implemented yet");

    }

    @Test
    void forwardToCashier() {
        fail("Not Implemented yet");

    }

    @Test
    void makePayment() {
        fail("Not Implemented yet");

    }

    @Test
    void giveReview() {
        fail("Not Implemented yet");

    }

    @Test
    Product searchCatalogue(String catalogueName, String productName, String manufacturer){
        ArrayList<Product> catalogue = MainCatalogue.findCatalogueByName(catalogueName);
        assertNotNull(catalogue);
        assertTrue(catalogue.size() > 0);

        String manufacturerName = manufacturer.trim().toLowerCase();
        int catalogueSize = catalogue.size();
        assertTrue(catalogueSize > 0);
        int index = 0;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            if (product.getManufacturerName().equals(manufacturerName) &&
                    product.name.equals(productName)){
                assertEquals(product.name, productName);
                assertEquals(product.manufacturer, manufacturer);


                return product;
            }

            index +=1;
        }

        return null;
    }


    @Test
    void handleProductSelection() {
        fail("Not Implemented yet");

    }

    @Test
    void print() {
        fail("Not Implemented yet");

    }

    @Test
    void updateNumberOfPatronage() {
        fail("Not Implemented yet");

    }

    @Override
    public void stateGender(String gender) {
        fail("Not Implemented yet");


    }

    @Override
    public boolean canWorkOverTime() {
        fail("Not Implemented yet");

        return false;
    }

    @Override
    public boolean isBonafideStaff(Staff staff) {
        fail("Not Implemented yet");

        return false;
    }


}