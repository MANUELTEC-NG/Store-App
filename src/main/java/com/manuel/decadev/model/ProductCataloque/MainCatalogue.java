package com.manuel.decadev.model.ProductCataloque;

import com.manuel.decadev.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class MainCatalogue  {


    public static ArrayList<Product> sendProdCatalogue(){
        // sending a particular catalogue to cashier for product
        // removal when item is bought by customer

        return null;
    }



        static private ArrayList<Product> cookiesShelve = new ArrayList<>();
        static private   ArrayList<Product> barsShelve = new ArrayList<>();
        static private ArrayList<Product> snacksShelve = new ArrayList<>();
        static private ArrayList<Product> crackersShelve = new ArrayList<>();

        // [crackers, snacks, bars, cookies]
        static private Map<String, ArrayList<Product>> storeShelve = new HashMap<>();

       static Set<String> values = storeShelve.keySet();

        // this holds the 9 products in store
        static private Map<String, Integer> productsInStore = new HashMap<>();


        public static void main(String[] args) throws IOException {
            partitionProductToCatalogues();
            displayRes();
        }

        public static void displayRes () {

            System.out.println( + storeShelve.size() + " Categories? \t");
            System.out.println("------------------------------------------");

            System.out.println( storeShelve.get("cookies").size() + " items " + "under cookies");
            System.out.println( + storeShelve.get("bars").size() + " items " + "under bars");
            System.out.println(  + storeShelve.get("snacks").size() + " items " + "under snacks" );
            System.out.println( + storeShelve.get("crackers").size() + " items " + "under crackers");

            System.out.println("------------------------------------------");
            System.out.println("Total Quantity Of Product Under 'Carrot' Category In Stock -> \t" + productsInStore.get("carrot") + " ");
            System.out.println("Total Quantity Of Product Under 'Banana' Category In Stock -> \t" + productsInStore.get("banana") + " ");
            System.out.println("Total Quantity Of Product Under 'Bran' Category In Stock -> \t" + productsInStore.get("bran") + " ");
            System.out.println("Total Quantity Of Product Under 'Crackers'  In Stock -> \t" + productsInStore.get("crackers") + " ");
            System.out.println("Total Quantity Of Product Under 'Potato chips'  In Stock -> \t" + productsInStore.get("potato chips") + " ");
            System.out.println("Total Quantity Of Product Under 'Pretzels'  In Stock -> \t" + productsInStore.get("pretzels") + " ");
            System.out.println("Total Quantity Of Product Under 'Arrowroot'  In Stock -> \t" + productsInStore.get("arrowroot") + " ");
            System.out.println("Total Quantity Of Product Under 'Chocolate Chip'  In Stock -> \t" + productsInStore.get("chocolate chip") + " ");
            System.out.println("Total Quantity Of Product Under 'Oatmeal Raisin'  In Stock -> \t" + productsInStore.get("oatmeal raisin") + " ");

            System.out.println("----------------------------------------\t");

            System.out.println( "Total of " +productsInStore.size() + " Products in store ");
            System.out.println("----------------------------------------\t");

            System.out.println("Store Shelve");
            System.out.println(storeShelve.keySet());

            Object[] v = values.toArray();
            System.out.println(v[0]);
        }

        public static void partitionProductToCatalogues () throws IOException {

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


                    if (categoryName.equals(COOKIES)){
                        // check wether product name is already in the inner map
                        // if already exist, use the product name to have access to the catalogue
                        // then add the product based on product name
                        addProductToShelve(unitPrice, productName, cookiesShelve);
                        // TODO
                        // cookieShelve not null
                        updateQuantityOfProduct(productsInStore, productName, productQty);
                        // TODO
                        // assert stockCounter is updated
                        pushToShelves(COOKIES, storeShelve, cookiesShelve);
                        // TODO
                        // Assert shelve has values
                        // Assert cookieShelve is added and that it holds values


                    }

                    else if (categoryName.equals(BARS)){

                        addProductToShelve(unitPrice, productName, barsShelve);
                        updateQuantityOfProduct(productsInStore, productName, productQty);
                        pushToShelves(BARS, storeShelve, barsShelve);

                    }

                    else if (categoryName.equals(SNACKS)){

                        addProductToShelve(unitPrice, productName, snacksShelve);
                        updateQuantityOfProduct(productsInStore, productName, productQty);
                        pushToShelves(SNACKS, storeShelve, snacksShelve);

                    }
                    else if (categoryName.equals(CRACKERS)){

                        addProductToShelve(unitPrice, productName, crackersShelve);
                        updateQuantityOfProduct(productsInStore, CRACKERS, productQty);
                        pushToShelves(CRACKERS, storeShelve, crackersShelve);

                    }

                }



            }

        }

        static private void updateQuantityOfProduct(Map<String, Integer> stock, String productName, int updateFigure){
            if (!stock.containsKey(productName)){
                stock.put(productName, updateFigure);
            } else {
                int numbInStock = stock.get(productName);
                stock.put(productName, numbInStock + updateFigure);
            }
        }
        static private void pushToShelves(String productCategory, Map<String, ArrayList<Product> > mainShelve, ArrayList<Product> subShelve ){
            String category = productCategory.toLowerCase();
            if  (!mainShelve.containsKey(category)){
                mainShelve.put(category, subShelve);
            } else {
                mainShelve.put(category, subShelve);
            }
            //shelves.get(category)
        }

        static private void addProductToShelve(double unitPrice, String productName,
                                               ArrayList<Product> categoryName){
            Product product =  new Product(unitPrice, productName);
            categoryName.add(product);
            //System.out.println("current capacity " + categoryName.size());
        }

    public static boolean checkProductAvailability(String productName){

        String name = productName.trim().toLowerCase();
        int size = productsInStore.size();
        while (size > 0){
        if (productsInStore.containsKey(name) && productsInStore.get(name) != 0){
            return true;

        }
            size -= 1;
        }
        return false;
    }




    public static Map<String, ArrayList<Product>> getStoreShelve() {
        return storeShelve;
    }

    public static ArrayList<Product> getCookiesShelve() {
        return cookiesShelve;
    }

    public static ArrayList<Product> getBarsShelve() {
        return barsShelve;
    }

    public static ArrayList<Product> getSnacksShelve() {
        return snacksShelve;
    }

    public static ArrayList<Product> getCrackersShelve() {
        return crackersShelve;
    }


    public static Map<String, Integer> getStock() {
        return productsInStore;
    }
}


