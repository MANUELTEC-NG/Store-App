package com.manuel.decadev;

import com.manuel.decadev.model.*;
import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store  {

    private static Cashier cashier;
    private static Manager aManager;
    private static MainCatalogue mainCatalogue;
    private static Customer customer;
    private static PrintHandler printHandler;

    static ArrayList<Product> chocolateCatalogue;
    static ArrayList<Product> oatmealCatalogue;
    static ArrayList<Product> arrowRootCatalogue;

    static ArrayList<Product> carrotCatalogue;
    static ArrayList<Product> branCatalogue;
    static ArrayList<Product> bananaCatalogue;

    static ArrayList<Product> pretzelsCatalogue;

    static ArrayList<Product> wholeWheatCatalogue;
    static ArrayList<Product> potatoChipsCatalogue;


    public static void main(String[] args) {
        try {
            MainCatalogue.partitionProductToCatalogues();
        } catch (IOException fileNotFoundException){

            System.out.println("Exception thrown in reading file");
            fileNotFoundException.printStackTrace();
            fileNotFoundException.getCause();
        }


        PrintHandler.outputHelperMethod("Product Successfully Loaded from file");
        //MainCatalogue.displayRes();

        //checkNonNull(chocolateCatalogue != null, "Chocolate Catalogue is empty");

        Customer customer = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 3447844);
        customer.setProductNameOfChoice("chocolate chip");
        try {
            Product selectedProduct = customer.searchCatalogue( customer.getProductNameOfChoice(), "chocolate");
            customer.setBankAccountInfo(new CusBankAccount(customer.getFirstName(),
                    customer.getLastName(), 30000));
            customer.purchaseProduct(selectedProduct.name, "chocolate");
            ArrayList<Product> customerProduct = customer.forwardProductToCashier();

            System.out.println(customerProduct.get(0));


        } catch (NullPointerException ex){
            ex.getMessage();
        }


       // interactWithManagerClass();
         //interactWithCahierClass();

    }


    public static void interactWithManagerClass(){


        aManager = new Manager("Olu","Master", "Male",
                "Engineering Department", "Store Manager", 10034);
        char retry;
        System.out.println("##########################################################");

        System.out.println("Heads up for the Manager's Intro");
        System.out.println("##########################################################");
        PrintHandler.outputHelperMethod("..................................");

        String selfIntro = "My name Is" + " "+aManager.getFirstName()+
                " "+ aManager.getLastName()+ "." + "A" +" "+aManager.getRole() +" "+"In the"+" "+aManager.getDepartment()+" "
                + "In"+" " + Manager.getCompanyName();

         cashier = new Cashier("Daniel", "Mary", "Sales Department",
                "Cashier", "Female", 5032);

        System.out.println(selfIntro);
        System.out.println("I am a level headed Manager and yet" +
                " I can fire lazy workers");

        System.out.println("Here is an example of my last disciplinary action");

        //aManager.issueQuery(mary);
       // aManager.fireCashier(cashier, "","",0);
        //aManager.issueQuery(mary);

        System.out.println("#############################################################");
    }

    public static void interactWithCahierClass(){

        Customer customer = new Customer("Sylva", "Dodo","Female",
                "something@gmail.com", 234-421-494);
       // mary.print(biscuits.get(0));
//        customer.print(customer)
    }


    public static int retry(Scanner scanner){
        char retry;
        System.out.println("---------------------------------------------------------");
        System.out.println("Would you want to have a RE-RUN?\n 'Y' for Yes & 'N' otherwise");
        retry = scanner.next().charAt(0);
        scanner.nextLine();
     return retry;
    }

    public static void prompt(){

        // write your code

        //Scanner scanner = new Scanner(System.in);
        // prompt();

            /*while (true) {

                int input =  scanner.next().charAt(0);

                if (input != '1' && input != '2' && input != 'Y') {
                    System.out.println("Quiting...Goodbye!");
                    System.exit(0);
                }

                if (input == '1') {
                    interactWithManagerClass();

                } else if (input == '2')
                    interactWithCahierClass();


                input = retry(scanner);

            }

        System.out.println("What class would you like to interact with?");
        System.out.println("For Manager Class \nPress -> 1\nFor Customer class -> Press 2\n" +
                "Press Any key to quit\n");
     */

    }
}
