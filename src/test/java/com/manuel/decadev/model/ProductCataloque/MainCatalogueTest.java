package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainCatalogueTest {

    static private ArrayList<Product> cookiesShelve = new ArrayList<>();
    static private   ArrayList<Product> barsShelve = new ArrayList<>();
    static private ArrayList<Product> snacksShelve = new ArrayList<>();
    static private ArrayList<Product> crackersShelve = new ArrayList<>();

    // [crackers, snacks, bars, cookies]
    static private Map<String, ArrayList<Product>> storeShelve = new HashMap<>();

    // this holds the 9 products in store
    static private Map<String, Integer> productsInStore = new HashMap<>();


    @BeforeEach
    void setUp() {

        String COOKIES = "cookies";
        String BARS = "bars";
        String SNACKS = "snacks";
        String CRACKERS = "crackers";


        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/dec/IdeaProjects/Store-App/src/main/java/com/manuel/decadev/resources/sampledatafoodsales.csv.csv");

            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] productData = line.split(",");
                String categoryName = productData[3].toLowerCase().trim();
                String productName = productData[4].toLowerCase().trim();
                int productQty = Integer.parseInt(productData[5]);
                double unitPrice = Double.parseDouble(productData[6]);
                double totalPrice = Double.parseDouble(productData[7]);


                if (categoryName.equals(COOKIES)) {
                    // check wether product name is already in the inner map
                    // if already exist, use the product name to have access to the catalogue
                    // then add the product based on product name
                    addProductToShelve(unitPrice, productName, cookiesShelve);
                    // TODO
                    // cookieShelve not null
                    int prevValue = updateQuantityOfProduct(productsInStore, productName, productQty);

                    // TODO
                    // assert stockCounter is updated
                    pushToShelves(COOKIES, storeShelve, cookiesShelve);
                    // TODO
                    // Assert shelve has values
                    // Assert cookieShelve is added and that it holds values


                } else if (categoryName.equals(BARS)) {

                    addProductToShelve(unitPrice, productName, barsShelve);
                    updateQuantityOfProduct(productsInStore, productName, productQty);
                    pushToShelves(BARS, storeShelve, barsShelve);

                } else if (categoryName.equals(SNACKS)) {

                    addProductToShelve(unitPrice, productName, snacksShelve);
                    updateQuantityOfProduct(productsInStore, productName, productQty);
                    pushToShelves(SNACKS, storeShelve, snacksShelve);

                } else if (categoryName.equals(CRACKERS)) {

                    addProductToShelve(unitPrice, productName, crackersShelve);
                    updateQuantityOfProduct(productsInStore, CRACKERS, productQty);
                    pushToShelves(CRACKERS, storeShelve, crackersShelve);

                }

            }


        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }



    }





    @Test
    void partitionProductToCatalogues() {

        String COOKIES = "cookies";
        String BARS = "bars";
        String SNACKS = "snacks";
        String CRACKERS = "crackers";


        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/dec/IdeaProjects/Store-App/src/main/java/com/manuel/decadev/resources/sampledatafoodsales.csv.csv");

            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] productData = line.split(",");
                String categoryName = productData[3].toLowerCase().trim();
                String productName = productData[4].toLowerCase().trim();
                int productQty = Integer.parseInt(productData[5]);
                double unitPrice = Double.parseDouble(productData[6]);
                double totalPrice = Double.parseDouble(productData[7]);


                if (categoryName.equals(COOKIES)) {
                    // check wether product name is already in the inner map
                    // if already exist, use the product name to have access to the catalogue
                    // then add the product based on product name
                  Product p =  addProductToShelve(unitPrice, productName, cookiesShelve);
                    // TODO
                    // cookieShelve not null


                    int prevQty = productsInStore.get(productName);
                    int newQty = updateQuantityOfProduct(productsInStore, productName, productQty);

                    // TODO
                    // assert stockCounter is updated
                    pushToShelves(COOKIES, storeShelve, cookiesShelve);

                    assertTrue(cookiesShelve.contains(p));
                    assertEquals(newQty, (prevQty+productQty));
                    assertTrue(storeShelve.containsKey(COOKIES));
                    assertNotNull(storeShelve.get(COOKIES));
                    assertTrue(storeShelve.get(COOKIES).size() > 0);

                    // TODO
                    // Assert shelve has values
                    // Assert cookieShelve is added and that it holds values


                } else if (categoryName.equals(BARS)) {

                    Product p =  addProductToShelve(unitPrice, productName, barsShelve);
                    int prevQty = productsInStore.get(productName);
                    int newQty = updateQuantityOfProduct(productsInStore, productName, productQty);
                    pushToShelves(BARS, storeShelve, barsShelve);


                   assertTrue(barsShelve.contains(p));
                    assertEquals(newQty, (prevQty+productQty));
                    assertTrue(storeShelve.containsKey(BARS));
                    assertNotNull(storeShelve.get(BARS));
                    assertTrue(storeShelve.get(BARS).size() > 0);


                } else if (categoryName.equals(SNACKS)) {

                    Product p = addProductToShelve(unitPrice, productName, snacksShelve);

                    int prevQty = productsInStore.get(productName);
                    int newQty = updateQuantityOfProduct(productsInStore, productName, productQty);
                    pushToShelves(SNACKS, storeShelve, snacksShelve);

                    assertTrue(snacksShelve.contains(p));
                    assertEquals(newQty, (prevQty+productQty));
                    assertTrue(storeShelve.containsKey(SNACKS));
                    assertNotNull(storeShelve.get(SNACKS));
                    assertTrue(storeShelve.get(SNACKS).size() > 0);


                } else if (categoryName.equals(CRACKERS)) {

                    Product p = addProductToShelve(unitPrice, productName, crackersShelve);
                    int prevQty = productsInStore.get(productName);
                    int newQty = updateQuantityOfProduct(productsInStore, CRACKERS, productQty);
                    pushToShelves(CRACKERS, storeShelve, crackersShelve);

                    assertTrue(crackersShelve.contains(p));
                    assertEquals(newQty, (prevQty+productQty));
                    assertTrue(storeShelve.containsKey(CRACKERS));
                    assertNotNull(storeShelve.get(CRACKERS));
                    assertTrue(storeShelve.get(CRACKERS).size() > 0);


                }

            }


        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    Map<String, ArrayList<Product>> getStoreShelve() {
        return storeShelve;
    }


    ArrayList<Product> getCookiesShelve() {
        return cookiesShelve;
    }



    @Test
    void testProductIsSuccessfullyAddedToShelve(){
        String productName = "chocolate chip";
        ArrayList<Product> categoryName = getCookiesShelve();
        double price = 45;
       Product product = addProductToShelve(price,productName ,categoryName);

        assertTrue(categoryName.contains(product));
        assertNotNull(categoryName);
        assertTrue(categoryName.size() > 1);

    }
    @Test
    void testProductNameIsInStore(){
        String product = "bran";
        boolean inStore = isProductInStore(product);
        assertTrue(inStore);
    }
    @Test
    void testProductNotInStore(){
        String product = "brandy";
        boolean inStore = isProductInStore(product);
        assertFalse(inStore);
    }
     Product addProductToShelve(double unitPrice, String productName, ArrayList<Product> categoryName){

        Product product =  new Product(unitPrice, productName);
        categoryName.add(product);

        //System.out.println("current capacity " + categoryName.size());
         return product;
    }
    static private int  updateQuantityOfProduct(Map<String, Integer> stock, String productName, int updateFigure){
        int prevQtyInStore = 0 ;
        if (!stock.containsKey(productName)){
            stock.put(productName, updateFigure);
        } else {
            prevQtyInStore = stock.get(productName);
            stock.put(productName, prevQtyInStore + updateFigure);
        }
        return stock.get(productName);
    }

    @Test
    void testKeyAndValueOfProductCategory(){

        String category = "snacks";
        Map<String, ArrayList<Product>> mainShelve = getStoreShelve();
        ArrayList<Product> subShelve  =  getCookiesShelve();

        pushToShelves(category, mainShelve, subShelve);

        assertTrue(storeShelve.containsKey(category));
        assertTrue(storeShelve.containsValue(subShelve));


    }

    static private void pushToShelves(String productCategory, Map<String, ArrayList<Product> > mainShelve,
                                      ArrayList<Product> subShelve ){

        String category = productCategory.toLowerCase();
        if  (!mainShelve.containsKey(category)){
            mainShelve.put(category, subShelve);
        } else {
            mainShelve.put(category, subShelve);
        }
        //shelves.get(category)
    }

    public static boolean isProductInStore(String productName){

        String name = productName.trim().toLowerCase();
        int size = productsInStore.size();
        while (size > 0){
            if (productsInStore.containsKey(name) && productsInStore.get(name) > 0){
                return true;

            }
            size -= 1;
        }
        return false;
    }
}