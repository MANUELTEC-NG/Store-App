package com.manuel.decadev;

import com.manuel.decadev.model.Cashier;
import com.manuel.decadev.model.Customer;
import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.Manager;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.ProductCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {

    private static Cashier mary;
    private static ArrayList<Biscuit> biscuits;

    public static void main(String[] args) {
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

             */

         biscuits = ProductCatalogue.getProductCatalogue("Biscuit");


         interactWithManagerClass();
         interactWithCahierClass();
    }

    /*
    public static void prompt(){
        System.out.println("What class would you like to interact with?");
        System.out.println("For Manager Class \nPress -> 1\nFor Customer class -> Press 2\n" +
                "Press Any key to quit\n");

    }*/

    public static void interactWithManagerClass(){


        Manager aManager = new Manager("Olu","Master", "Male",
                "Engineering Department", "Store Manager", 10034);
        char retry;
        System.out.println("##########################################################");

        System.out.println("Heads up for the Manager's Intro");
        System.out.println("##########################################################");
        PrintHandler.outputHelperMethod("..................................");

        String selfIntro = "My name Is" + " "+aManager.getFirstName()+
                " "+ aManager.getLastName()+ "." + "A" +" "+aManager.getRole() +" "+"In the"+" "+aManager.getDepartment()+" "
                + "In"+" " + Manager.getCompanyName();

         mary = new Cashier("Daniel", "Mary", "Sales Department",
                "Cashier", "Female", 5032);

        System.out.println(selfIntro);
        System.out.println("I am a level headed Manager and yet" +
                " I can fire lazy workers");

        System.out.println("Here is an example of my last disciplinary action");

        //aManager.issueQuery(mary);
        aManager.fireEmployee(mary, "","",0);
        //aManager.issueQuery(mary);

        System.out.println("#############################################################");
    }

    public static void interactWithCahierClass(){

        Customer customer = new Customer("Sylva", "Dodo","Female",
                "something@gmail.com", 234-421-494);
        mary.print(biscuits.get(0));
//        customer.print(customer);

    }

    public static int retry(Scanner scanner){
        char retry;
        System.out.println("---------------------------------------------------------");
        System.out.println("Would you want to have a RE-RUN?\n 'Y' for Yes & 'N' otherwise");
        retry = scanner.next().charAt(0);
        scanner.nextLine();
     return retry;
    }
}
