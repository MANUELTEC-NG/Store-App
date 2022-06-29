package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.ProductCatalogue;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements IPrint <Customer> {
    static int numberOfPatronage = 0;
    private String email;
    private double phone;

    ArrayList<Biscuit> biscuits;


    public Customer(String firstName, String lastName, String gender, String email, double phone) {
        super(firstName, lastName, gender);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Biscuit purchaseProduct(String productType, String productName) {
        // TODO
        // implement purchase method
        if (productType.toLowerCase().equals("Biscuit".toLowerCase())) {
            ArrayList<Biscuit> biscuits = ProductCatalogue.getProductCatalogue(productType);
            // makePayment();
            if (biscuits != null) {
                for(Biscuit biscuit : biscuits) {
                    if (biscuit.getProductNAme().equals(productName)) {
                        //makePayment(biscuit);
                        // Asserts true here
                        return biscuit;
                    }
                    //biscuits.remove(biscuit);
                }
            }
        }

        return  null;
    }

    public boolean makePayment (Product forProduct) {
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        updateNumberOfPatronage();
        return true;
    }
    public void giveReview (Product productBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public Biscuit handleProductSelection ( String productName){
        biscuits =  ProductCatalogue.getProductCatalogue("biscuit");

        //TODO
        // Assert not null

        for (Biscuit biscuit : biscuits) {
            if (biscuit.getProductNAme().equals(productName)){
                return biscuit;
            }
        }
        //return "";
        return null;
    }

    @Override
    public void print ( Customer customer) {
        System.out.println("Customer" + " " + this.getFirstName() + " "
                + this.getLastName() + "bought product.");
        System.out.println("Fully paid!");
    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }


}
