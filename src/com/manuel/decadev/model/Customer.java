package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IReceipt;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.ProductCatalogue;

import java.util.ArrayList;

public class Customer implements IReceipt {
    String firstName = "";
    String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    String email = "";
    double phone = 1-234-567-890;

    Product product;
    ArrayList<Product> productArrayList;
    ProductCatalogue productCatalogue;

    public Customer(String firstName, String lastName, String email, double phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public void purchaseProduct(String productType, String productName){

        // TODO
        // implement purchase method
        if (productType.equals("Biscuit")) {
           ArrayList<Biscuit> biscuits = ProductCatalogue.getBiscuitsCatalogue();
           makePayment();
           biscuits.forEach(biscuit -> {
               if(biscuit.getProductNAme().equals(productName)){
                   printReceipt();
                   biscuits.remove(biscuit);


               }
           });

        }
    }

    public void makePayment(){
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
    }

    public void giveReview(){
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public void handleProductSelection(Product catalogue, String productName){


    }

    public void printReceipt(){
        System.out.println("Custumer" + " " + this.getFirstName() +" "
                + this.getLastName() + "fully paid for the product");
    }


}
