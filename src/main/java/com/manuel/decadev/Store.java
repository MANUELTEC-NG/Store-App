package com.manuel.decadev;

import com.manuel.decadev.model.*;
import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Store  {

    private static Cashier cashier;
    private static Manager aManager;
    private static MainCatalogue mainCatalogue;

    static Queue<Customer> customersInQueue = new LinkedList<>();
    static CusBankAccount bankWallet;

    public static void main(String[] args) {
        try {
            MainCatalogue.partitionProductToCatalogues();
            PrintHandler.outputHelperMethod("Product Successfully Loaded from file");
            PrintHandler.outputHelperMethod("Store Open for Service");

        } catch (IOException fileNotFoundException){

            System.out.println("Exception thrown in reading file");
            fileNotFoundException.printStackTrace();
            fileNotFoundException.getCause();
        }

        setUpCustomers();

        cashier = new Cashier("Daniel", "Mary", "Sales Department",
                "Cashier", "Female", 5032);
        attendToCustomerFIFO();







        //MainCatalogue.displayRes();

        //checkNonNull(chocolateCatalogue != null, "Chocolate Catalogue is empty");

        Customer customer = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 3447844);
         bankWallet = new CusBankAccount(customer.getFirstName(),
                customer.getLastName(), 30000);
                customer.setBankAccountInfo(bankWallet);
                //customer.promptInput();
               // ArrayList<Product> customerProduct = customer.forwardProductToCashier();



       // interactWithManagerClass();
         //interactWithCahierClass();

    }

    private static void attendToCustomerFIFO() {

        for (int i = 0; i < customersInQueue.size(); i += 1) {

            cashier.receiveOrdersInfoFromCustomer(customersInQueue.element());
            // remove customer from queue next
            PrintHandler.outputHelperMethod( customersInQueue.size() + " Customers Are Queued");
            customersInQueue.poll();
            PrintHandler.outputHelperMethod(customersInQueue.size() + " Customers Are Remaining");

        }
    }

    static void setUpCustomers(){
        Customer customer1 = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 1-243-2625);
        Customer customer2 = new Customer("Adele", "Mars", "female", "fhfh@gmail", 123-324-356);
        Customer customer3 = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 234-535-743);
        customer1.setBankAccountInfo(bankWallet);
        customer2.setBankAccountInfo(bankWallet);
        customer3.setBankAccountInfo(bankWallet);
        if (doManualInputFromCus()) {
            customer1.getProductChoices().clear();
            customer2.getProductChoices().clear();
            customer3.getProductChoices().clear();
            customer1.getItemQuantity().clear();
            customer2.getItemQuantity().clear();
            customer3.getItemQuantity().clear();

            customer1.promptInput();
            customer2.promptInput();
            customer3.promptInput();
        }
        customersInQueue.offer(customer1);
        customersInQueue.offer(customer2);
        customersInQueue.offer(customer3);

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

    static boolean doManualInputFromCus(){
        Scanner input = new Scanner(System.in);
        System.out.println("Auto Input ? ");
        String res = input.nextLine().toLowerCase();
        if (!res.equals("yes")){
            return true;
        }
        return false;
    }
}
