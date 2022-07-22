package com.manuel.decadev.model;

import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.util.*;

public class Customer extends Person  {
    static int numberOfPatronage = 0;
    private final String email;
    private final double phone;
    private final String fullName = firstName +" "+lastName;

    // customer stating what he wants to buy
    private double priceBudget = 0;
    private int quantityOfProduct = 0;
    public boolean isValidated = false;
    CusBankAccount bankInfo;
    public int customerProdQty;
    private double totalPrice = 0;

    List<Product> customerCart = new ArrayList<>();
    private List<String> productNameOfChoice = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    ArrayList<Product> productShelve;


   // List<Product>
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


    public String makePayment (Product item, int quantity) {
        bankInfo.setCustomerFName(firstName);
        bankInfo.setCustomerLastName(lastName);

        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        System.out.println("Customer is making payment...");
        String notifMsg = "Issues with making payment";
        if (hasBalance()){
            double balance = bankInfo.getBankBalance();
            double currentCharges = item.getPrice() * quantity;
             totalPrice += currentCharges;
            this.bankInfo.setBankBalance(balance - currentCharges );
            notifMsg = "Payment Successful";

            PrintHandler.outputHelperMethod(notifMsg);

            System.out.println("$" + (item.getPrice() * quantity) + " " + "charged from" + " " + bankInfo.getCustomerFName() + " Bank Account");
            updateNumberOfPatronage();

        } else {
            System.out.println("Can't process orders \n Not enough fund in account");
        }


        return notifMsg;
    }

    public void giveReview (Product itemBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }


    private void findMatchingProduct(ArrayList<Product> list, String choice) {

        for (Product product : list){
            if (product.getName().matches(choice) || product.getName().equals(choice)){
                customerCart.add(product);
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
                quantities.add(quantityOfProduct);

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

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

   public void selectProductForPurchase(Product name) throws Exception {
        if (!this.isValidated){
            System.out.println("You are not permitted for purchase yet");
            throw new Exception("Purchase permission not allowed");
        }

        //findMatchingProduct();


   }

   public boolean hasChoicePreference(){
        return (productNameOfChoice.size() != 0 && quantities.size() != 0);
   }
    public  String searchCatalogueForProduct(String productName ){

        String COOKIES = "cookies";
        String BARS = "bars";
        String SNACKS = "snacks";
        String CRACKERS = "crackers";
        String NOTFOUND = "Product Not Under Any Category";

        boolean found = MainCatalogue.isProductInStore(productName);

        if (!found) {
            System.out.println("Sorry, the Product is not available at this time");
            throw  new NullPointerException("Product Not Returned");
        }
        if (productNameOfChoice.size() == 0){
            productNameOfChoice = Cashier.forwardAutoPopulatedChoices();
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
                productShelve = MainCatalogue.getStoreShelve().get(COOKIES);
                findMatchingProduct(productShelve, choice);
                return  COOKIES;
            } else if (CARROT || BRAN || BANANA){
                productShelve =  MainCatalogue.getStoreShelve().get(BARS);
                findMatchingProduct(productShelve, choice);
                return  BARS;
            } else if (POTATO || PRETZEL){
                productShelve =  MainCatalogue.getStoreShelve().get(SNACKS);
                findMatchingProduct(productShelve, choice);
                return  SNACKS;
            } else if (WHOLE || WHEAT){
                productShelve =  MainCatalogue.getStoreShelve().get(CRACKERS);
                findMatchingProduct(productShelve, choice);
                return  CRACKERS;
            }


        }

        return NOTFOUND;
    }

    public List<String> getProductChoices() {
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

    public List<Product> getCustomerCart() {
        return customerCart;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getFullName() {
        return fullName;
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
