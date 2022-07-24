package com.manuel.decadev;

import com.manuel.decadev.model.*;
import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.io.IOException;
import java.util.*;

//github remote name: week-3-task-Yhello-G
// https://github.com/decadevs/week-3-task-Yhello-G


public class Store  {

    private static Cashier cashier;
    private static Manager aManager;
    private static MainCatalogue mainCatalogue;

    static Queue<Customer> customersInQueue = new LinkedList<>();

    static PriorityQueue<Customer> priorityQueue = new PriorityQueue<Customer>(3, new CustomerComparator());
    static CusBankAccount c1Wallet;
    static CusBankAccount c2Wallet;
    static CusBankAccount c3Wallet;


   static Customer customer1 = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 1-243-2625);
   static   Customer customer2 = new Customer("Adele", "Mars", "female", "fhfh@gmail", 123-324-356);
   static   Customer customer3 = new Customer("David", "Malan", "male", "fhfh@gmail", 234-535-743);

   static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            MainCatalogue.partitionProductToCatalogues();
            PrintHandler.outputHelperMethod("Product Successfully Loaded from file");
            MainCatalogue.displayRes();
            PrintHandler.outputHelperMethod("Store Open for Service");
            System.out.println();
            PrintHandler.outputHelperMethod(".............................................");

        } catch (IOException fileNotFoundException){

            System.out.println("Exception thrown in reading file");
            fileNotFoundException.printStackTrace();
            fileNotFoundException.getCause();
        }



        cashier = new Cashier("Daniel", "Mary", "Sales Department",
                "Cashier", "Female", 5032);

        c1Wallet = new CusBankAccount(customer1.getFirstName(),
                customer1.getLastName(), 30000);
        c2Wallet = new CusBankAccount(customer2.getFirstName(),
                customer2.getLastName(), 30000);
        c3Wallet =  new CusBankAccount(customer3.getFirstName(),
                customer3.getLastName(), 30000);

        customer1.setBankAccountInfo(c1Wallet);
        customer2.setBankAccountInfo(c2Wallet);
        customer3.setBankAccountInfo(c3Wallet);


        setUpCustomers();
        attendToCustomer(true);

        // setUpCustomersPriority();
        //attendToBasedOnPriority();







        //MainCatalogue.displayRes();

        //checkNonNull(chocolateCatalogue != null, "Chocolate Catalogue is empty");

        Customer customer = new Customer("Micheal", "Jordan", "male", "fhfh@gmail", 3447844);
         c1Wallet = new CusBankAccount(customer.getFirstName(),
                customer.getLastName(), 30000);
                customer.setBankAccountInfo(c1Wallet);
                //customer.promptInput();
               // ArrayList<Product> customerProduct = customer.forwardProductToCashier();



       // interactWithManagerClass();
         //interactWithCahierClass();

    }

    private static void attendToCustomer(boolean isSpecialCustomer) {
        int numOfPeople = customersInQueue.size();
        Customer specialCustomer = null;

        for (int i = 0; i < numOfPeople; i += 1) {
            Customer aCustomer = customersInQueue.element();
           specialCustomer = cashier.receiveOrdersInfoFromCustomer(aCustomer, isSpecialCustomer);
           specialCustomer.customerProdQty += i*3;

           if (isSpecialCustomer && specialCustomer != null){
               priorityQueue.offer(specialCustomer);
           }
            // remove customer from queue next


            PrintHandler.outputHelperMethod( customersInQueue.size() + " ->  Customers Are Queued Orderly");
            aCustomer =  customersInQueue.poll();

            PrintHandler.outputHelperMethod("Customer : " + aCustomer.getFullName()+ " is Attended to by the Cashier");
            PrintHandler.outputHelperMethod(customersInQueue.size() + " -> Customers Are Remaining");
            PrintHandler.outputHelperMethod("------------------------------------------------");
        }

        PrintHandler.outputHelperMethod("Would you want to see SAME OPERATION but on priority based scenario?");
        String resp = input.nextLine();
        if (resp.equals("yes")) {

            attendToBasedOnPriority();
        }
    }



    private static void attendToBasedOnPriority(){
        int size = priorityQueue.size();
        Customer specialCustomer;
        int i = 0;
        if (i == size-1)
            System.out.println("Done with all the customers!");

        for ( i = 0; i < size; i += 1) {


            // remove customer from queue next
            PrintHandler.outputHelperMethod("##### Simulating Cashier Selling to High Priority Customer #####");
            PrintHandler.outputHelperMethod("Attending to Customers Based On Numbers Of Quantity They Want to Buy");

            if (i == 0)
                PrintHandler.outputHelperMethod( priorityQueue.size() + " ->  Customers Are Queued");

            specialCustomer = priorityQueue.poll();
            String fullName = specialCustomer.getFullName();
            int qty = specialCustomer.customerProdQty;
            PrintHandler.outputHelperMethod(  fullName +  ":"+ " buying " + qty + ".  Attended to by the Cashier");
            PrintHandler.outputHelperMethod(priorityQueue.size() + " -> Customers Are Remaining");
            PrintHandler.outputHelperMethod("------------------------------------------------");
        }
    }



    static void setUpCustomers(){
         customer1.setBankAccountInfo(c1Wallet);
        customer2.setBankAccountInfo(c1Wallet);
        customer3.setBankAccountInfo(c1Wallet);
        if (doManualInputFromCus()) {
            customer1.getProductChoices().clear();
            customer2.getProductChoices().clear();
            customer3.getProductChoices().clear();
            customer1.getQuantities().clear();
            customer2.getQuantities().clear();
            customer3.getQuantities().clear();

//            customer1.promptInput();
//            customer2.promptInput();
//            customer3.promptInput();
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
