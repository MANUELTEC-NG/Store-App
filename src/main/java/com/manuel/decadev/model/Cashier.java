package com.manuel.decadev.model;


import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;
import com.manuel.decadev.model.threads.SellThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cashier extends  Staff implements IPrint <Customer, Product> {

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;
    private int workExperience = 0;
    static List<String> customersIntendedOrders;
    private   ArrayList<Product> productShelve = new ArrayList<>();
    private Map<String, Integer> storeInventories;
    List<Product> currentCustomerCart = new ArrayList<>();
    List<Integer> correspondingQty  =  new ArrayList<>();
    public int currentCustomerQty;
    public static Customer currentCustomer;
    public String currentProduct;
    public String currentProdCategory;

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }


    public Cashier(String firstName, String lastName, String department, String role, String gender, int compId) {
        super(firstName,lastName, gender, department, role, compId);
    }
    public Cashier(){
        super();
    }

    public void sellProduct (String productName, String category) throws Exception{
        // TODO
        // Implement the logic of cashier withdrawing money from customer's account
        // and removing product from catalogue
        //  Product product = toCustomer.purchaseProduct(purchasedProduct.name, purchasedProduct.manufacturer);
        int qtyAvailableInStore;
        storeInventories = MainCatalogue.getStock();
        String selectedProductCategory = category.toLowerCase();
        int i = -1;

        for (int j = 0; i < currentCustomerCart.size(); i += 1){
            i += 1;
            if (checkInventory(currentCustomerCart.get(j).getName())){
                PrintHandler.outputHelperMethod("Current Quantity In Stock : "
                        + storeInventories.get(productName));

                qtyAvailableInStore = storeInventories.get(productName) - currentCustomerQty;
                storeInventories.put(selectedProductCategory, qtyAvailableInStore);
                PrintHandler.outputHelperMethod("Product Successfully Bought");

            } else {

                PrintHandler.outputHelperMethod("Something went wrong. \n Can't find "
                        + currentCustomerCart.get(i).getName());
            }
        }
    }
    public Customer receiveOrdersInfoFromCustomer(Customer customer, boolean isSpecialCustomer){
        // customers already in normal queue is passed
        // extract their orders info
        // check availability of their intended product of choice
        //  sell
        //customer.promptInput();
        this.currentCustomer = customer;
        String categoryName = "";
        if (customer.hasChoicePreference()) {
            customersIntendedOrders = new ArrayList<>(customer.getProductChoices());
            correspondingQty = new ArrayList<>(customer.getQuantities());
        } else{
            customersIntendedOrders = Arrays.asList("chocolate chip", "bran", "banana");
             correspondingQty = Arrays.asList(5,6,10);
        }

        boolean available = false;

       for (String productName : customersIntendedOrders) {
           try {
               available = checkInventory(productName);

           } catch (Exception ex){
               ex.getMessage();
           }
       }

       if (available) {
                validateCustomerForPurchase(customer, true);
                // cashier allows customer to go have the
                currentCustomerCart = customer.confirmProductsAvailability(customersIntendedOrders);
                // the cart from this customer is returned
            }

       if (currentCustomerCart.size() > 0) {
            int counter = -1;
            // the reference of the customer is kept so he can be used for payment processing

            for (int i = 0; i < currentCustomerCart.size(); i += 1) {

                currentCustomerQty = correspondingQty.get((i));

                customer.customerProdQty = currentCustomerQty;
                // customer account is charged with equivalent product amount
                if ( customer.makePayment(currentCustomerCart.get(i),
                        currentCustomerQty, customer.bankInfo)){
                    try {
                        // run();
                        SellThread sellThread = new SellThread(this, currentCustomer);

                        Thread thread = new Thread(sellThread.runnable);
                        thread.start();

                      //  sellProduct(currentCustomerCart.get(i).getName(), categoryName);
                        counter += 1;
                    } catch (Exception ex){
                        ex.getMessage();
                    }
                }else {

                }


                // removed from cart

            }


            currentCustomer = customer;
            print(customer, currentCustomerCart.get(0));

            if (isSpecialCustomer) {
                return currentCustomer;
            }
        }

        return null;
    }

    private boolean confirmProductAvailability(ArrayList<Product> list, String choice) {

        for (Product product : list){
            if (product.getName().matches(choice) || product.getName().equals(choice)){

                return true;
            }
        }
        System.out.println("Oops, Item is sold out!");
        return false;
    }

    // hard code the product name here
    public  boolean checkInventory(String productName ) throws Exception{
        boolean found = MainCatalogue.isProductInStore(productName);

        if (!found) {
            System.out.println("Sorry, the Product is not available at this time");
            throw  new NullPointerException("Product Not Returned");
        }

        for (String choice : customersIntendedOrders) {
            // System.out.println(Str.matches("(.*)Tutorials(.*)"));
            // Cookie
            boolean CHOCO = choice.matches("(.*)choco(.*)");
            boolean ARR = choice.matches("(.*)Arr(.*)");
            boolean OATMEAL = choice.matches("(.*)oat(.*)");

            // Bars
            boolean CARROT = choice.matches("(.*)car(.*)");
            boolean BRAN = choice.matches("(.*)bran(.*)");
            boolean BANANA = choice.matches("(.*)ban(.*)");

            //Snacks
            boolean POTATO = choice.matches("(.*)po(.*)");
            boolean PRETZEL = choice.matches("(.*)pret(.*)");

            //Crackers
            boolean WHOLE = choice.matches("(.*)whole(.*)");
            boolean WHEAT = choice.matches("(.*)whea(.*)");


            if (CHOCO || ARR || OATMEAL){
                Map<String,ArrayList <Product> >tempShelve = MainCatalogue.getStoreShelve();
                productShelve = tempShelve.get("cookies");
                confirmProductAvailability(productShelve, choice);
                return  true;
            } else if (CARROT || BRAN || BANANA){
                productShelve =  MainCatalogue.getStoreShelve().get("bars");
                confirmProductAvailability(productShelve, choice);
                return  true;
            } else if (POTATO || PRETZEL){
                productShelve =  MainCatalogue.getStoreShelve().get("snacks");
                confirmProductAvailability(productShelve, choice);
                return  true;
            } else if (WHOLE || WHEAT){
                productShelve =  MainCatalogue.getStoreShelve().get("crackers");
                confirmProductAvailability(productShelve, choice);
                return  true;
            }
        }

        return false;
    }
    public void validateCustomerForPurchase(Customer customer, Boolean remark){
        customer.isValidated = remark;
    }
    @Override
    public void print(Customer c, Product product){

        System.out.println("Printing Receipt for Customer");
        System.out.println("________________________________________________________");
        System.out.println("Customer Bought a Product");
        System.out.println("Customer: " + " " + c.getFullName() + " "+ "bought product.");
        System.out.println("\t" + "$"+c.getTotalPrice() + " \tFully paid!");



    }

    static public List<String> forwardAutoPopulatedChoices() {
        return customersIntendedOrders;
    }

    @Override
    public void stateGender(String gender){
        setGender(gender);
    }

    @Override
    public boolean canWorkOverTime(){

        return true;
    }

    public void setAllowableAbsentTimes(short allowableAbsentTimes) {
        Cashier.allowableAbsentTimes = allowableAbsentTimes;
    }

    public short getWeeklyHour() {
        return weeklyHour;
    }

    public short getAllowableAbsentTimes() {
        return allowableAbsentTimes;
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public boolean isBonafideStaff(Staff staff){
        Cashier cashier = (Cashier) staff;
        boolean bonafide = false;
        int id = cashier.getId();
        String firstName = cashier.getFirstName();
        String lastName = cashier.getLastName();
        if( id != 0 && firstName != "" && lastName != "" ){
            bonafide = true;
            return bonafide;
        }

        return bonafide;
    }

    public int setWorkExperience(int years){
        return this.workExperience = years;
    }

    public int retrieveWorkExperience() {
        return workExperience;
    }


}
