package com.manuel.decadev.model;

import com.manuel.decadev.model.Handlers.PrintHandler;
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


    public String makePayment (Product item, int quantity, CusBankAccount wallet) {

        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        System.out.println("Customer is making payment...");
        String notifMsg = "Issues with making payment";

        try{
            if (hasBalance(wallet)){

                double balance = wallet.getBankBalance();
                double currentCharges = item.getPrice() * quantity;
                totalPrice += currentCharges;
                wallet.setBankBalance(balance - currentCharges );
                notifMsg = "Payment Successful";

                PrintHandler.outputHelperMethod(notifMsg);

                System.out.println("$" + (item.getPrice() * quantity) + " " + "charged from" + " " + bankInfo.getCustomerFName() + " Bank Account");

            } else {
                System.out.println("Can't process orders \n Not enough fund in account");
            }

        } catch (Exception ex){

            System.out.println(ex.getMessage());
        }


         return notifMsg;

    }

    public void giveReview (Product itemBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }


    private boolean addProdChoiceToCart(ArrayList<Product> list, String choice) throws Exception {
       /* boolean match = false;
        int remaingQty;
        for (Product product : list){
            remaingQty = (MainCatalogue.getStock().get(product.getName()) - 1);
            if (remaingQty != 0 && product.getName().matches(choice) || product.getName().equals(choice)){
                match = true;
                customerCart.add(product);

                MainCatalogue.getStock().put(product.getName(), remaingQty);
                if (remaingQty == 0){
                    System.out.println("This product is out of stock");
                    return false;
                }
                //TODO
                // Check if product added

            }

        }


        return match;

        */


        boolean match = false;

        int remaingQty;
        for (Product product : list) {
            remaingQty = MainCatalogue.getStock().get(product.getName());
            if ((remaingQty != 0 && product.getName().matches(choice) )|| product.getName().equals(choice)) {
                remaingQty -= 1;
                match = true;
                customerCart.add(product);
                // remove this product
                list.remove(product);
                MainCatalogue.getStock().put(product.getName(), remaingQty);
                return true;
                /*if (remaingQty == 0) {
                    System.out.println("This product is out of stock");
                    throw new Exception("Out of stock Exception");
                    //return false;
                } */
                //TODO
                // Check if product added

            }

        }


        return match;
    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }


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
        return (this.productNameOfChoice.size() != 0 && this.quantities.size() != 0);
   }
    public  List<Product> searchCatalogueForProduct(List<String> customerItemList ) {

        String category = "";
        boolean found = false;
        // comfirm if items are in store
        for (String productName : customerItemList) {
            found = MainCatalogue.isProductInStore(productName);

            if (!found) {
                System.out.println("Sorry, the Product is not available at this time");
                throw new NullPointerException("Product Not Returned");
            }
            // add product to cart
           find(productName);

        }

       return customerCart;
    }


    private  String find(String choice){

        String COOKIES = "cookies";
        String BARS = "bars";
        String SNACKS = "snacks";
        String CRACKERS = "crackers";

        String NOTFOUND = "Product Not Under Any Category";
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


        if (CHOCO || ARR || OATMEAL) {
            productShelve = MainCatalogue.getStoreShelve().get(COOKIES);
            try {
                addProdChoiceToCart(productShelve, choice);
            } catch (Exception e) {
                e.getMessage();
            }
            return  COOKIES;
        } else if (CARROT || BRAN || BANANA) {
            productShelve = MainCatalogue.getStoreShelve().get(BARS);
            try {
                addProdChoiceToCart(productShelve, choice);
            } catch (Exception e) {
                e.getMessage();
            }
            return  BARS;
        } else if (POTATO || PRETZEL) {
            productShelve = MainCatalogue.getStoreShelve().get(SNACKS);
            try {
                addProdChoiceToCart(productShelve, choice);
            } catch (Exception e) {
                e.getMessage();
            }
             return  SNACKS;
        } else if (WHOLE || WHEAT) {
            productShelve = MainCatalogue.getStoreShelve().get(CRACKERS);
            try {
                addProdChoiceToCart(productShelve, choice);
            } catch (Exception e) {
                e.getMessage();
            }
            return CRACKERS;

        }
        return "NOT FOUND IN ANY OF THE STORE CATEGORY";
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

    public CusBankAccount getBankInfo(CusBankAccount wallet) {

        if (wallet == null) {
            throw new NullPointerException("Customer's Account Information is Not Set Yet");
        }
        return bankInfo;
    }

    public boolean hasBalance(CusBankAccount wallet) throws Exception {
        if (wallet != null && wallet.getBankBalance() > 0)
            return true;
        throw new Exception("Balance is too low");
    }



}
