package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;

import java.util.ArrayList;

import static com.manuel.decadev.model.ProductCataloque.MainCatalogue.findCatalogueByName;

public class Customer extends Person implements IPrint <Product, Customer> {
    static int numberOfPatronage = 0;
    private final String email;
    private final double phone;
    private String productNameOfChoice = "";
    private double priceBudget = 0;

    CusBankAccount bankInfo;
    ArrayList<Product> selectedProducts = new ArrayList<>();

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


    public void purchaseProduct(String productName, String fromCatalogue) {
        // TODO
        // implement purchase method
       Product product = this.searchCatalogue(productName, fromCatalogue);
        makePayment(product);
        selectedProducts.add(product);

    }

    public ArrayList<Product> forwardProductToCashier() {

        return selectedProducts;
    }

    public String makePayment (Product item) {
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        System.out.println("Payment method entered");
        String notifMsg = "Issues with making payment";
        if (hasBalance()){
            double balance = bankInfo.getBankBalance();
            double productPrice = item.price;
            this.bankInfo.setBankBalance(balance - productPrice );
            System.out.println("Payment made successfully");
            System.out.println("$" + item.price + " " + "charged from" + " " + bankInfo.getCustomerFName() + " Bank Account");
            notifMsg = "Payment Successful";
            updateNumberOfPatronage();

        }


        return notifMsg;
    }
    public void giveReview (Product itemBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public  Product searchCatalogue(String productName, String catalogueName ) {

        ArrayList<Product> catalogue = findCatalogueByName(catalogueName);
        if (catalogue == null) {
            throw  new NullPointerException("Empty Product Catalogue Returned");
        }
        int catalogueSize = catalogue.size();
        int index = 0;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            if (product.name.equals(productName)){

                return product;
            }

            index +=1;
        }

        return null;
    }


    @Override
    public void print (Product forProduct, Customer customer) {
        System.out.println("Customer" + " " + super.firstName + " "
                + super.lastName +" " + "bought product.");
//        System.out.println("@\t" + forProduct.price + "\tFully paid!");
    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }


    public void setProductNameOfChoice(String productNameOfChoice) {
        this.productNameOfChoice = productNameOfChoice;
    }

    public void setPriceBudget(double priceBudget) {
        this.priceBudget = priceBudget;
    }
    public static int getNumberOfPatronage() {
        return numberOfPatronage;
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

    public String getProductNameOfChoice() {
        return productNameOfChoice;
    }

    public double getPriceBudget() {
        return priceBudget;
    }

    public void setBankAccountInfo(CusBankAccount bankAccount){

        this.bankInfo = bankAccount;
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
