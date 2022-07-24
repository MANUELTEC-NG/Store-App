package com.manuel.decadev.model;

import com.manuel.decadev.model.Handlers.PrintHandler;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest extends Person {

    static int numberOfPatronage = 0;
    private  String email;
    private  double phone;
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
    Product product;

    @BeforeEach
    void setUp() {

         bankInfo = new CusBankAccount("Michael",
                "Jordan", 10000);
         product = new Product(100, "bran");

         customerProdQty = 10;
        try {
            MainCatalogue.partitionProductToCatalogues();
        } catch (Exception exception){

        }
         productShelve = MainCatalogue.getStoreShelve().get("cookies");

    }

    @AfterEach
    void tearDown() {
    }


    void makePayment(Product item, int quantity, CusBankAccount wallet)  {

       // bankInfo.setCustomerFName(firstName);
        //bankInfo.setCustomerLastName(lastName);


        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        System.out.println("Customer is making payment...");
        String notifMsg = "Issues with making payment";


        try{
            assertTrue(hasBalance(wallet));
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


       // return notifMsg;
    }

    @Test
    void testSuccessfulPayment(){
        Product item = product;
        int quantity = customerProdQty;

        makePayment(item, quantity, bankInfo);

    }

    @Test
    void testUnsuccessfulPayment(){
        Product item = product;
        int quantity = customerProdQty;

        makePayment(item, quantity, new CusBankAccount("Micheal", "Jordan", -1));
    }

    @Test
    void testRetrievalOfBankAccount(){
        assertNotNull(getBankInfo(bankInfo));
    }

    @Test
    void testForExceptionWhenBankAccountIsNotSet(){
        assertThrows(Exception.class, ()-> getBankInfo(null));
    }


    @Test
    void selectProductForPurchase() {
    }

    @Test
    void hasChoicePreference() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"chocolate chip", "bran", "carrot"})
    void searchCatalogueForProduct(String productName) {

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
        assertTrue(productNameOfChoice.size() == 0);
        if (productNameOfChoice.size() == 0){
            productNameOfChoice = Cashier.forwardAutoPopulatedChoices();
        }
        productNameOfChoice = Arrays.asList("chocolate chip"/*, "bran", "banana"*/);
        assertTrue(productNameOfChoice.size() > 0);
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
                assertTrue(productShelve.size() > 0);
                try{
                    findMatchingProduct(productShelve, choice);
                } catch (Exception e){
                    e.getMessage();
                }
                //return  COOKIES;
            } else if (CARROT || BRAN || BANANA){
                productShelve =  MainCatalogue.getStoreShelve().get(BARS);
                try{
                    findMatchingProduct(productShelve, choice);
                } catch (Exception e){
                    e.getMessage();
                }
                //return  BARS;
            } else if (POTATO || PRETZEL){
                productShelve =  MainCatalogue.getStoreShelve().get(SNACKS);
                try{
                    findMatchingProduct(productShelve, choice);
                } catch (Exception e){
                    e.getMessage();
                }
               // return  SNACKS;
            } else if (WHOLE || WHEAT){
                productShelve =  MainCatalogue.getStoreShelve().get(CRACKERS);
                try{
                    findMatchingProduct(productShelve, choice);
                } catch (Exception e){
                    e.getMessage();
                }
               // return  CRACKERS;
            }


        }

       // return NOTFOUND;
    }

    @Test
    void testForProductMatch() throws Exception{

       assertTrue(findMatchingProduct(productShelve, "chocolate chip"));

    }
    @Test
    void testForProductNameNotFound() throws Exception{

        assertFalse(findMatchingProduct(productShelve, "okokobioko"));
    }

    @Test
    void testForOutOfStockCase() {

        String pName = "chocolate chip";
        final int[] len = {productShelve.size()};
        assertThrows(Exception.class, ()->  {while (len[0] != 0){

            findMatchingProduct(productShelve, pName);
            len[0]--;
        }} );
    }

     public boolean findMatchingProduct(ArrayList<Product> list, String choice) throws Exception{
        boolean match = false;
        int remaingQty;
        for (Product product : list) {
            remaingQty = (MainCatalogue.getStock().get(product.getName()) - 1);
            if (remaingQty != 0 && product.getName().matches(choice) || product.getName().equals(choice)) {
                match = true;
                customerCart.add(product);

                MainCatalogue.getStock().put(product.getName(), remaingQty);
                if (remaingQty == 0) {
                    System.out.println("This product is out of stock");
                    throw new Exception("Out of stock Exception");
                    //return false;
                }
                //TODO
                // Check if product added

            }

        }


        return match;
    }

    @Test
    void getProductChoices() {
    }

    @Test
    void getPriceBudget() {
    }

    @Test
    void setBankAccountInfo() {
    }

    @Test
    void setPriceBudget() {
    }

    @Test
    void getNumberOfPatronage() {
    }

    @Test
    void getCustomerCart() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getPhone() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void getTotalPrice() {
    }

    @Test
    void getFullName() {
    }


    CusBankAccount getBankInfo(CusBankAccount wallet) {

        if (wallet == null) {
            throw new NullPointerException("Customer's Account Information is Not Set Yet");
        }
        return bankInfo;
    }


   boolean hasBalance(CusBankAccount wallet) throws Exception {
       if (wallet != null && wallet.getBankBalance() > 0)
           return true;
       throw new Exception("Balance is too low");

    }
}