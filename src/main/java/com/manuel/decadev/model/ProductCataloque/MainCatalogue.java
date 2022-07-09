package com.manuel.decadev.model.ProductCataloque;


import com.manuel.decadev.Store;
import com.manuel.decadev.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCatalogue  {

    static ArrayList<Product> chocolateCatalogue;
    static  ArrayList<Product> oatmealCatalogue;
    static ArrayList<Product> arrowRootCatalogue;

    static ArrayList<Product> carrotCatalogue;
    static  ArrayList<Product> branCatalogue;
    static ArrayList<Product> bananaCatalogue;

    static ArrayList<Product> pretzelsCatalogue;

    static  ArrayList<Product> wholeWheatCatalogue ;
    static ArrayList<Product> potatoChipsCatalogue;

    private MainCatalogue(){
        try{

            partitionProductToCatalogues();
        } catch (IOException ioException){
            System.out.println("Something went wrong in the PartitionProductCatalogue");
            ioException.printStackTrace();
        }

    }

    public static void displayRes() {

        System.out.println("Numbers of Chocolates in Chocolate Catalogue:\t" + CookieCatalogue.getChocoCatalogue().size());
        System.out.println("Numbers of ArrowRoots in ArrowRoot Catalogue:\t" + CookieCatalogue.getArrowRootCatalogue().size());
        System.out.println("Numbers of Oat in Oat Catalogue Catalogue:\t" + CookieCatalogue.getOatCatalogue().size());
        System.out.println("------------------------------------------");
        System.out.println("Numbers of Carrots in Carrot Catalogue:\t" + BarsCatalogue.getCarrotCatalogue().size());
        System.out.println("Numbers of Bran in Bran Catalogue: \t" + BarsCatalogue.getBranCatalogue().size());
        System.out.println("Numbers of Bananas in Banana Catalogue:\t" + BarsCatalogue.getBananaCatalogue().size());
        System.out.println("----------------------------------------\t");
        System.out.println("Numbers of Pretzels in Pretzel Catalogue:\t" + SnacksCatalogue.getPretzelCatalogue().size());
        System.out.println("----------------------------------");
        System.out.println("Numbers of Whole Meat in Whole Meat Catalogue:\t" + CrackersCatalogue.getWholeWheatCatalogue().size());
        System.out.println("Numbers of Potatoes in Potato Catalogue:\t" +  CrackersCatalogue.getPotatoChipCatalogue().size());




    }

    public static void partitionProductToCatalogues() throws  IOException{
          chocolateCatalogue = CookieCatalogue.getChocoCatalogue();

          try(
                  FileInputStream fileInputStream = new FileInputStream("/Users/dec/IdeaProjects/Store-App/src/main/java/com/manuel/decadev/resources/sampledatafoodsales.csv.csv");

                  Scanner scanner = new Scanner(fileInputStream)

          ){
              while (scanner.hasNext()){
                  String line = scanner.nextLine();
                  String[] productData = line.split(",");
                  String categoryName = productData[3].toLowerCase().trim();
                  String productName = productData[4].toLowerCase().trim();
                  int productQty = Integer.parseInt(  productData[5] );
                  double unitPrice = Double.parseDouble(productData[6]);
                  double totalPrice = Double.parseDouble(productData[7]);


                  if ( categoryName.equals("cookies")){
                      if (productName.equals("chocolate chip")){
                          chocolateCatalogue = CookieCatalogue.getChocoCatalogue();
                          Product chocolate = new Product((int)unitPrice, productName, categoryName);
                          chocolateCatalogue.add(chocolate);

                          CookieCatalogue.setTotalChocoQty(CookieCatalogue.getTotalChocoQty() + productQty);

                      } else if (productName.equals("oatmeal raisin")){

                          oatmealCatalogue = CookieCatalogue.getOatCatalogue();
                          Product oatmeal = new Product((int)unitPrice, productName, categoryName);
                          oatmealCatalogue.add(oatmeal);
                          CookieCatalogue.setTotalOatQuantity(CookieCatalogue.getTotalOatQuantity() + productQty);

                      } else if (productName.equals("arrowroot")){

                          arrowRootCatalogue = CookieCatalogue.getArrowRootCatalogue();
                          Product arrowroot =new Product((int)unitPrice, productName, categoryName);
                          arrowRootCatalogue.add(arrowroot);
                          CookieCatalogue.setTotalArrowRootQty(CookieCatalogue.getTotalArrowRootQty() + productQty);

                      }

                  }



                 else if (categoryName.equals("bars")){
                      if (productName.equals("carrot")){
                         carrotCatalogue = BarsCatalogue.getCarrotCatalogue();
                         Product carrot = new Product((int)unitPrice, productName, categoryName);
                         carrotCatalogue.add(carrot);

                         BarsCatalogue.setTotalCarrotQty(BarsCatalogue.getTotalCarrotQty() + productQty);

                      } else if ( productName.equals("bran")){

                          branCatalogue = BarsCatalogue.getBranCatalogue();
                          Product bran = new Product((int)unitPrice, productName, categoryName);
                          branCatalogue.add(bran);
                          BarsCatalogue.setTotalBranQuantity(BarsCatalogue.getTotalBranQuantity() + productQty);
                      }

                      else if (productName.equals("banana")){
                          bananaCatalogue = BarsCatalogue.getBananaCatalogue();
                          Product banana = new Product((int)unitPrice, productName, categoryName);
                          bananaCatalogue.add(banana);
                          BarsCatalogue.setTotalBananaQty(BarsCatalogue.getTotalBananaQty() + productQty);
                      }
                  }

                 else if (categoryName.equals("snacks")){

                      if (productName.equals("potato chips")){

                          potatoChipsCatalogue = CrackersCatalogue.getPotatoChipCatalogue();
                          Product potato = new Product((int)unitPrice, productName, categoryName);
                          potatoChipsCatalogue.add(potato);
                          CrackersCatalogue.setTotalPotatoChipQty(CrackersCatalogue.getTotalPotatoChipQty() + productQty);
                      }


                      pretzelsCatalogue = SnacksCatalogue.getPretzelCatalogue();
                      Product pretzel = new Product((int)unitPrice, productName, categoryName);
                      pretzelsCatalogue.add(pretzel);

                      SnacksCatalogue.setTotalPretzelQty(SnacksCatalogue.getTotalPretzelQty() + productQty);



                  }


                   else if (categoryName.equals("crackers")){

                      if (productName.equals("whole wheat")){

                          wholeWheatCatalogue = CrackersCatalogue.getWholeWheatCatalogue();
                          Product wheat = new Product((int)unitPrice, productName, categoryName);
                          wholeWheatCatalogue.add(wheat);
                          CrackersCatalogue.setTotalWholeWheatQty(CrackersCatalogue.getTotalWholeWheatQty() + productQty);
                      }


                  }
              }

          }

     }

    public static ArrayList<Product> findCatalogueByName(String productName){

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
               // return new ArrayList<Product>();
                return null;
        }


    }

    public static ArrayList<Product> sendProdCatalogue(){
        // sending a particular catalogue to cashier for product
        // removal when item is bought by customer

        return chocolateCatalogue;
    }






}
