package com.manuel.decadev.model.ProductCataloque;


import com.manuel.decadev.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCatalogue {

    static ArrayList<Product> chocolateCatalogue;
    static  ArrayList<Product> oatmealCatalogue;
    static ArrayList<Product> arrowRootCatalogue;

    static ArrayList<Product> carrotCatalogue;
    static  ArrayList<Product> branCatalogue;
    static ArrayList<Product> bananaCatalogue;

    static ArrayList<Product> pretzelsCatalogue;

    static  ArrayList<Product> wholeWheatCatalogue ;
    static ArrayList<Product> potatoChipsCatalogue;



    public static void main(String[] args) throws IOException  {

                partitionProductToCatalogues();

        ///System.out.println(choco.size());
        //System.out.println(CookieCatalogue.isSameThing());
        System.out.println(CookieCatalogue.getChocoCatalogue().size());
        System.out.printf("Total Amounts Chocolate %s \t Whole Wheat %s", CookieCatalogue.getTotalChocoQty(), CrackersCatalogue.getTotalWholeWheatQty());
        System.out.println(CookieCatalogue.getArrowRootCatalogue().size());
        System.out.println(CookieCatalogue.getOatCatalogue().size());
        System.out.println("------------------------------------------");
        System.out.println(BarsCatalogue.getCarrotCatalogue().size());
        System.out.println(BarsCatalogue.getBranCatalogue().size());
        System.out.println(BarsCatalogue.getBananaCatalogue().size());
        System.out.println("----------------------------------------");
        System.out.println(SnacksCatalogue.getPretzelCatalogue().size());
        System.out.println("----------------------------------");
        System.out.println(CrackersCatalogue.getWholeWheatCatalogue().size());
        System.out.println(CrackersCatalogue.getPotatoChipCatalogue().size());




    }
    private MainCatalogue(){
        try{

            partitionProductToCatalogues();
        } catch (IOException ioException){
            System.out.println("Something went wrong in the PartitionProductCatalogue");
            ioException.printStackTrace();
        }

    }


    static private void partitionProductToCatalogues() throws  IOException{

        ArrayList<String> totalCategory = new ArrayList<>();

          chocolateCatalogue = CookieCatalogue.getChocoCatalogue();

          try(
                  FileInputStream fileInputStream = new FileInputStream("/Users/dec/IdeaProjects/Store-App/sampledatafoodsales.csv.csv");

                  Scanner scanner = new Scanner(fileInputStream);

          ){
              while (scanner.hasNext()){
                  String line = scanner.nextLine();
                  String[] productData = line.split(",");
                  String categoryName = productData[3].toLowerCase().trim();
                  String productName = productData[4].toLowerCase().trim();
                  int productQty = Integer.parseInt(  productData[5] );
                  double unitPrice = Double.parseDouble(productData[6]);
                  double totalPrice = Double.parseDouble(productData[7]);

                  if (!(totalCategory.contains(categoryName))) {
                      totalCategory.add(categoryName);
                  }

                  if ( categoryName.equals("cookies")){
                      if (productName.equals("chocolate chip")){
                          chocolateCatalogue = CookieCatalogue.getChocoCatalogue();
                          chocolateCatalogue.add(new Product((int)unitPrice, productName,
                                  "Yoyo", 2021, categoryName));
                          CookieCatalogue.setTotalChocoQty(CookieCatalogue.getTotalChocoQty() + productQty);
                      } else if (productName.equals("oatmeal raisin")){

                          oatmealCatalogue = CookieCatalogue.getOatCatalogue();
                          oatmealCatalogue.add(new Product((int)unitPrice, productName,
                                  "Yoyo", 2021, categoryName));
                          CookieCatalogue.setTotalOatQuantity(CookieCatalogue.getTotalOatQuantity() + productQty);

                      } else if (productName.equals("arrowroot")){

                          arrowRootCatalogue = CookieCatalogue.getArrowRootCatalogue();
                          arrowRootCatalogue.add(new Product((int)unitPrice, productName,
                                  "Yoyo", 2021, categoryName));
                          CookieCatalogue.setTotalArrowRootQty(CookieCatalogue.getTotalArrowRootQty() + productQty);

                      }

                  }



                  if (categoryName.equals("bars")){
                      if (productName.equals("carrot")){
                         carrotCatalogue = BarsCatalogue.getCarrotCatalogue();
                         Product carrot = new Product((int)unitPrice, productName,
                                 "OkCarrot", 2021, categoryName);
                         carrotCatalogue.add(carrot);

                         BarsCatalogue.setTotalCarrotQty(BarsCatalogue.getTotalCarrotQty() + productQty);

                      } else if ( productName.equals("bran")){

                          branCatalogue = BarsCatalogue.getBranCatalogue();
                          Product bran = new Product((int)unitPrice, productName,
                                  "CoolBran", 2021, categoryName);
                          branCatalogue.add(bran);
                          BarsCatalogue.setTotalBranQuantity(BarsCatalogue.getTotalBranQuantity() + productQty);
                      }

                      else if (productName.equals("banana")){
                          bananaCatalogue = BarsCatalogue.getBananaCatalogue();
                          Product banana = new Product((int)unitPrice, productName,
                                  "RiteFoods", 2021, categoryName);
                          bananaCatalogue.add(banana);
                          BarsCatalogue.setTotalBananaQty(BarsCatalogue.getTotalBananaQty() + productQty);
                      }
                  }

                  if (categoryName.equals("snacks")){

                      if (productName.equals("potato chips")){

                          potatoChipsCatalogue = CrackersCatalogue.getPotatoChipCatalogue();
                          Product potato = new Product((int)unitPrice, productName,
                                  "Sweetz", 2021, categoryName);
                          potatoChipsCatalogue.add(potato);
                          CrackersCatalogue.setTotalPotatoChipQty(CrackersCatalogue.getTotalPotatoChipQty() + productQty);
                      }


                      pretzelsCatalogue = SnacksCatalogue.getPretzelCatalogue();
                      Product pretzel = new Product((int)unitPrice, productName,
                              "PretzelFoods", 2021, categoryName);
                      pretzelsCatalogue.add(pretzel);

                      SnacksCatalogue.setTotalPretzelQty(SnacksCatalogue.getTotalPretzelQty() + productQty);



                  }


                  if (categoryName.equals("crackers")){

                      if (productName.equals("whole wheat")){

                          wholeWheatCatalogue = CrackersCatalogue.getWholeWheatCatalogue();
                          Product wheat = new Product((int)unitPrice, productName,
                                  "WheatWezz", 2021, categoryName);
                          wholeWheatCatalogue.add(wheat);
                          CrackersCatalogue.setTotalWholeWheatQty(CrackersCatalogue.getTotalWholeWheatQty() + productQty);

                      }


                  }



              }

          }



//         }


     }

    private static ArrayList<Product> selectProduct(String productName){

        String name = productName.trim().toLowerCase();
        switch (name){

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

    public static Product searchCatalogue(String productName, String manufacturer){
        ArrayList<Product> catalogue = selectProduct(productName);
        // TODO
        // check non null here


        String manufacturerName = manufacturer.trim().toLowerCase();
        int catalogueSize = catalogue.size();
        int index = 0;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            if (product.getManufacturerName().equals(manufacturerName)){
                return product;
            }

            index +=1;
        }

        return null;
    }
    public static ArrayList<Product> sendProdCatalogue(){
        // sending a particular catalogue to cashier for product
        // removal when item is bought by customer

        return chocolateCatalogue;
    }






}
