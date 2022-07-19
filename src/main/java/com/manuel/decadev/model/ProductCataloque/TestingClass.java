package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

import java.util.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TestingClass {


    static private Map<String, ArrayList<Product>> storeShelve = new HashMap<>();

    static private ArrayList<Product> cookiesShelve;
    static private ArrayList<Product> barsShelve;
    static private ArrayList<Product> snacksShelve;
    static private ArrayList<Product> crackersShelve;


    static Map<String, ArrayList<Product>> shelves = new HashMap<>();


    static Map<String, Integer> stockCounter = new HashMap<>();


    private TestingClass() {
        try {
            partitionProductToCatalogues();
        } catch (IOException ioException) {
            System.out.println("Something went wrong in the PartitionProductCatalogue");
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        partitionProductToCatalogues();


    }


    public static void partitionProductToCatalogues() throws IOException {

        String COOKIES = "cookies";
        String BARS = "bars";
        String SNACKS = "snacks";
        String CRACKERS = "crackers";


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


                if (categoryName.equals(COOKIES)) {
                    // check wether product name is already in the inner map
                    // if already exist, use the product name to have access to the catalogue
                    // then add the product based on product name
                    addProductToShelve(unitPrice, productName, cookiesShelve);
                    // TODO
                    // cookieShelve not null
                    updateQuantityOfProduct(stockCounter, COOKIES, productQty);
                    // TODO
                    // assert stockCounter is updated
                    pushToShelves(COOKIES, storeShelve, cookiesShelve);
                    // TODO
                    // Assert shelve has values
                    // Assert cookieShelve is added and that it holds values


                } else if (categoryName.equals(BARS)) {

                    addProductToShelve(unitPrice, productName, barsShelve);
                    updateQuantityOfProduct(stockCounter, BARS, productQty);

                } else if (categoryName.equals(SNACKS)) {

                    addProductToShelve(unitPrice, productName, snacksShelve);
                    updateQuantityOfProduct(stockCounter, SNACKS, productQty);

                } else if (categoryName.equals(CRACKERS)) {

                    addProductToShelve(unitPrice, productName, crackersShelve);
                    updateQuantityOfProduct(stockCounter, CRACKERS, productQty);

                }

            }

        }

    }

    static private void updateQuantityOfProduct(Map<String, Integer> productRecord, String nameOfProduct, int updateFigure) {
        if (!productRecord.containsKey(nameOfProduct)) {
            productRecord.put(nameOfProduct, updateFigure);
        } else {
            int numbInStock = productRecord.get(nameOfProduct);
            productRecord.put(nameOfProduct, numbInStock + updateFigure);
        }
    }

    static private void pushToShelves(String productCategory, Map<String, ArrayList<Product>> mainShelve, ArrayList<Product> subShelve) {
        String category = productCategory.toLowerCase();
        if (!mainShelve.containsKey(category)) {
            mainShelve.put(category, subShelve);
        } else {
            mainShelve.put(category, subShelve);
        }
        //shelves.get(category)
    }

    static private void addProductToShelve(double unitPrice, String productName,
                                           ArrayList<Product> categoryName) {
        Product product = new Product(unitPrice, productName);
        categoryName.add(product);

    }


    public static int arrayPacking(ArrayList<Integer> integers) {
        //00011000      added from last to first
        //01010101
        //00000000
        String fourth = "";
        String third = "";
        String second = "";
        String first = "";
        // loop through from last to first
        // convert each integer to binary
        // when loop done merge the 0s and 1s from first to last
        // convert back to base 10 decimal
        //int i = integers.size(); //4
        int counter = 0;
        for (  int i = integers.size(); i > 0; i--) {
            counter += 1;

            if (counter == 1) {

                while (i > 0) {
                    fourth += i % 2;
                    i = i / 2;
                }
            }

            if (counter == 2) {
                while (i > 0) {
                    third += i % 2;
                    i = i / 2;
                }
            }


            if (counter == 3) {
                while (i > 0) {
                    second += i % 2;
                    i = i / 2;
                }
            }


            if (counter == 4) {
                while (i < 0) {
                    first += i % 2;
                    i = i / 2;
                }
            }


            String sInt = fourth + third + second + first;
            int res = Integer.parseInt(sInt);



        }

        return 0;
    }
}