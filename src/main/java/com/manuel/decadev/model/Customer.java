package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;
import com.manuel.decadev.model.ProductCataloque.ProductCatalogue;

import java.util.ArrayList;

public class Customer extends Person implements IPrint <Product, Customer> {
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

    public Product purchaseProduct(String productName, String manufacturer) {
        // TODO
        // implement purchase method
        Product product = handleProductSelection(productName, manufacturer);
        makePayment(product);

        forwardToCashier(product);
        print(product, this );


        return  null;
    }

    public static Product forwardToCashier(Product p) {
        return p;
    }

    public boolean makePayment (Product forItem) {
        // TODO
        //implement the logic of making payment
        // issue payment to the Store Bank Account
        updateNumberOfPatronage();
        return true;
    }
    public void giveReview (Product itemBrand) {
        // TODO - implement logic of
        // customer giving review to product bought
    }

    public Product handleProductSelection ( String productName, String searchBy){

        String searchQuery = searchBy.trim().toLowerCase();
       Product product = MainCatalogue.searchCatalogue(productName, searchQuery);
       if (product != null)
           return product;


       return null;
    }

    @Override
    public void print (Product forProduct, Customer customer) {
        System.out.println("Customer" + " " + this.getFirstName() + " "
                + this.getLastName() + "bought product.");
        System.out.println("@\t" + forProduct.price + "\tFully paid!");
    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }


}
