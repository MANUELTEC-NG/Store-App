package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.ProductCatalogue;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements IPrint {
    static int numberOfPatronage = 0;
    private String email;
    private  double phone;

    Product product;
    //ArrayList<Product> productArrayList;
    ProductCatalogue productCatalogue;


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

    public void purchaseProduct(String productType, String productName){

        // TODO
        // implement purchase method
        if (productType.equals("Biscuit")) {

            // might throw exception

           List<Biscuit> biscuits = (ArrayList<Biscuit>) ProductCatalogue.getCatalogue("Biscuit");
           makePayment();
            if ( biscuits != null)
                biscuits.forEach(biscuit -> {
                if(biscuit.getProductNAme().equals(productName)){
                   print();
                   biscuits.remove(biscuit);


               }
           });

        }
    }

    public void makePayment(){
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        updateNumberOfPatronage();
    }

    public void giveReview(){
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public void handleProductSelection(Product catalogue, String productName){


    }

    public void print(){
        System.out.println("Customer" + " " + this.getFirstName() +" "
                + this.getLastName() + "bought product.");
        System.out.println("Fully paid!");
    }

    public void updateNumberOfPatronage(){

        this.numberOfPatronage += 1;
    }
}
