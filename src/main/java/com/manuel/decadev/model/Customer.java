package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.util.*;

import static com.manuel.decadev.model.ProductCataloque.MainCatalogue.checkProductAvailability;

public class Customer extends Person implements IPrint <Product, Customer> {
    static int numberOfPatronage = 0;
    private final String email;
    private final double phone;

    // customer stating what he wants to buy
    private ArrayList<String> productNameOfChoice = new ArrayList<>();
    private ArrayList<Integer> itemQuantity = new ArrayList<>();
    private double priceBudget = 0;
    private int quantityOfProduct = 0;
    public  ArrayList<Product> productShelve = new ArrayList<>();
    Map<String, ArrayList<Product>> shelve;
    CusBankAccount bankInfo;
    List<Product> custCart = new ArrayList<>();


    public Customer(String firstName, String lastName, String gender, String email, double phone) {
        super(firstName, lastName, gender);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;

    }
    public Customer(CusBankAccount bank, double phone,  String email){
        super(bank.getCustomerFName(), bank.getCustomerFName(), "");
        this.email = email;
        this.phone = phone;

    }

    public Customer(){
        this("John", "Doe", "male", "johndoe@gmail.com", 123-456-789);
    }


    public void purchaseProduct(String productName, String fromCatalogue) {
        // TODO
        // implement purchase method
//       Product product = this.searchCatalogue(productName, fromCatalogue);
//        makePayment(product);
//        custCart.add(product);

    }

    public List<Product> forwardProductToCashier() {

        return custCart;
    }

    public String makePayment (Product item) {
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        System.out.println("Payment method entered");
        String notifMsg = "Issues with making payment";
        if (hasBalance()){
            double balance = bankInfo.getBankBalance();
            double productPrice = item.getPrice();
            this.bankInfo.setBankBalance(balance - productPrice );
            System.out.println("Payment made successfully");
            System.out.println("$" + item.getPrice() + " " + "charged from" + " " + bankInfo.getCustomerFName() + " Bank Account");
            notifMsg = "Payment Successful";
            updateNumberOfPatronage();

        }


        return notifMsg;
    }
    public void giveReview (Product itemBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public  Product searchCatalogueForProduct(String productName ) {
        boolean found = MainCatalogue.checkProductAvailability(productName);

        if (!found) {
            System.out.println("Sorry, the Product is not available at this time");
            throw  new NullPointerException("Product Not Returned");
        }
        for (String choice : productNameOfChoice) {
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
                findMatchingProduct(productShelve, choice);
           } else if (CARROT || BRAN || BANANA){
               productShelve =  MainCatalogue.getStoreShelve().get("bars");
               findMatchingProduct(productShelve, choice);

            } else if (POTATO || PRETZEL){
                productShelve =  MainCatalogue.getStoreShelve().get("snacks");
                findMatchingProduct(productShelve, choice);
            } else if (WHOLE || WHEAT){
                productShelve =  MainCatalogue.getStoreShelve().get("crackers");
                findMatchingProduct(productShelve, choice);
            }


        }

        return null;
    }

    private void findMatchingProduct(ArrayList<Product> list, String choice) {

        for (Product product : list){
            if (product.getName().matches(choice) || product.getName().equals(choice)){
                custCart.add(product);
                //TODO
                // Check if product added
                return;
            }

        }
        System.out.println("Product Name Not Found");

    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }

//    public void setProductNameOfChoice(String productNameOfChoice) {
//        this.productNameOfChoice.add(productNameOfChoice);
//    }

    public void promptInput(){
        Scanner input = new Scanner(System.in);
        String msg = "Welcome to our Store";
        String nameOfProduct = "";
        System.out.println(msg);
        System.out.println("Would want to buy something?");
        String response = input.nextLine().toLowerCase();


        while (!response.equals("No") && response.charAt(0) != 'N'){
            int j = 1;
            msg =  "Please Enter The Name of the Product you want to buy";

            while(j <= 2){
            if (j == 1) {
                System.out.println(msg);
                System.out.println("E.g chocolate chip");
               nameOfProduct = input.nextLine();
               productNameOfChoice.add(nameOfProduct);
                msg = "Please Enter the Quantity of the product";

            } else {
                System.out.println(msg);
                quantityOfProduct = input.nextInt();
                itemQuantity.add(quantityOfProduct);

                input.nextLine();
            }
                j+=1;
        }
            msg = "Do You Want To buy More Product? : No / N to Quit";
            System.out.println(msg);
            response = input.nextLine();

        }
        System.out.println("###########################################");
        System.out.println(productNameOfChoice);
        System.out.println(quantityOfProduct);
    }

    public ArrayList<Integer> getItemQuantity() {
        return itemQuantity;
    }

    @Override
    public void print (Product forProduct, Customer customer) {
        System.out.println("Customer" + " " + super.firstName + " "
                + super.lastName +" " + "bought product.");
//        System.out.println("@\t" + forProduct.price + "\tFully paid!");
    }
    public ArrayList<String> getProductChoices() {
        return productNameOfChoice;
    }
    public double getPriceBudget() {
        return priceBudget;
    }

    public void setBankAccountInfo(CusBankAccount bankAccount){

        this.bankInfo = bankAccount;
    }
    public void setPriceBudget(double priceBudget) {
        this.priceBudget = priceBudget;
    }
    public static int getNumberOfPatronage() {
        return numberOfPatronage;
    }

    public List<Product> getCustCart() {
        return custCart;
    }

    public String getEmail() {
        return email;
    }

    public double getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public CusBankAccount getBankInfo() {

        if (bankInfo == null) {
            throw new NullPointerException("Customer's Account Information is Not Set Yet");
        }
        return bankInfo;
    }

    public boolean hasBalance(){
        if (bankInfo != null && bankInfo.getBankBalance() > 0)
            return true;
        return false;
    }



}
