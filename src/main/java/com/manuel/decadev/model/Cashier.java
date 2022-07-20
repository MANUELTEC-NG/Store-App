package com.manuel.decadev.model;


import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cashier extends  Staff implements IPrint <Product, Customer>{

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;
    private int workExperience = 0;
    ArrayList<String> customersIntendedOrders = new ArrayList<>();
    ArrayList<Integer> correspondingQty = new ArrayList<>();

    private   ArrayList<Product> productShelve = new ArrayList<>();
    private Map<String, Integer> prodoctsAvailableInStore;

    //info for the customer in question
    List<Product> currentCustomerCart = new ArrayList<>();
    Customer currentCustomer;
    int currentCustomerQty;

    public Cashier(String firstName, String lastName, String department, String role, String gender, int compId) {
        super(firstName,lastName, gender, department, role, compId);

    }

    public Cashier(){
        super();
    }

    private void sellProduct (){
        // TODO
        // Implement the logic of cashier withdrawing money from customer's account
        // and removing product from catalogue
        //  Product product = toCustomer.purchaseProduct(purchasedProduct.name, purchasedProduct.manufacturer);
        int qtyAvailableInStore;
        prodoctsAvailableInStore = MainCatalogue.getStock();
        int i = -1;
        for (Product product : currentCustomerCart){
            i += 1;
            if (searchCatalogueForProduct(product.getName())){

                qtyAvailableInStore = prodoctsAvailableInStore.get("cookie") - currentCustomerQty;
                prodoctsAvailableInStore.put("cookie", qtyAvailableInStore);
                PrintHandler.outputHelperMethod("Product Successfully Bought");
                PrintHandler.outputHelperMethod("Updated Quantity In Stock is : "
                        + prodoctsAvailableInStore.get("cookie"));
            } else {

                PrintHandler.outputHelperMethod("Something went wrong. \n Can't find "
                        + currentCustomerCart.get(i).getName());
            }
        }

    }

    public void receiveOrdersInfoFromCustomer(Customer customer){
        // customers already in normal queue is passed
        // extract their orders info
        // check availability of their intended product of choice
        //  sell

        //copies the content in the customer array to the cashier
        int counter = -1;
        customersIntendedOrders = new ArrayList<>(customer.getProductChoices());
        correspondingQty = new ArrayList<>(customer.getItemQuantity());

        for (String productName : customersIntendedOrders) {
            boolean available =  searchCatalogueForProduct(productName);
            if (available){
                validateCustomerForPurchase(customer,true);
                // cashier allows customer to go have the
                customer.searchCatalogueForProduct(productName);
                // the cart from this customer is returned
                currentCustomerCart = customer.getCustCart();
                // the reference of the customer is kept so he can be used for payment processing
                for (Product product : currentCustomerCart){
                    // customer account is charged with equivalent product amount
                    currentCustomerQty = correspondingQty.get((counter + 1));
                    customer.makePayment(product, currentCustomerQty);

                    // removed from cart
                    sellProduct();
                }

                currentCustomer = customer;

            } else {
                System.out.println("Your Orders didn't go through");
            }
        }

    }

    private boolean isProductAvailability(ArrayList<Product> list, String choice) {

        for (Product product : list){
            if (product.getName().matches(choice) || product.getName().equals(choice)){

                return true;
            }
        }

        System.out.println("Oops, The Item is sold out!");
        return false;
    }

    // hard code the product name here
    public  boolean searchCatalogueForProduct(String productName ) {
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
                productShelve = MainCatalogue.getStoreShelve().get("cookie");
                isProductAvailability(productShelve, choice);
                return  true;
            } else if (CARROT || BRAN || BANANA){
                productShelve =  MainCatalogue.getStoreShelve().get("bars");
                isProductAvailability(productShelve, choice);
                return  true;
            } else if (POTATO || PRETZEL){
                productShelve =  MainCatalogue.getStoreShelve().get("snacks");
                isProductAvailability(productShelve, choice);
                return  true;
            } else if (WHOLE || WHEAT){
                productShelve =  MainCatalogue.getStoreShelve().get("crackers");
                isProductAvailability(productShelve, choice);
                return  true;
            }


        }

        return false;
    }
    public void validateCustomerForPurchase(Customer customer, Boolean remark){
        customer.isValidated = remark;
    }
    @Override
    public void print(Product item, Customer customer){

        String desc = item.getPrice() + " " + item.manufacturer;
        System.out.println("Cashier Printing Receipt for Customer");
        System.out.println("________________________________________________________");
        System.out.println("Customer Bought a Product");
        System.out.println(desc);
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

//    private void removeProductFromCatalogue(Product product){
//        ArrayList<Product> catalogue = MainCatalogue.sendProdCatalogue();
//        int size = catalogue.size();
//        int i = 0;
//
//        while (i < size){
//            Product p = catalogue.get(i);
//            if (p.getName().equals(product.getName())){
//                catalogue.remove(product);
//                // TODO
//                // check if true
//
//            }
//
//
//            i++;
//        }
//    }
}
