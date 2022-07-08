package com.manuel.decadev.model;

import com.manuel.decadev.model.Interface.IPrint;

import java.util.ArrayList;

import static com.manuel.decadev.model.ProductCataloque.MainCatalogue.findCatalogueByName;

public class Customer extends Person implements IPrint <Product, Customer> {
    static int numberOfPatronage = 0;
    private String email;
    private double phone;

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

    public  Product searchCatalogue(String catalogueName, String productName, String manufacturer){

        ArrayList<Product> catalogue = findCatalogueByName(catalogueName);
        // TODO
        // check non null here


        String manufacturerName = manufacturer.trim().toLowerCase();
        int catalogueSize = catalogue.size();
        int index = 0;

        while (index < catalogueSize){
            Product product = catalogue.get(index);
            if (product.getManufacturerName().equals(manufacturerName) &&
                    product.name.equals(productName)){

                return product;
            }

            index +=1;
        }

        return null;
    }

    public Product handleProductSelection ( String productName, String searchBy){

        String searchQuery = searchBy.trim().toLowerCase();
       Product product = this.searchCatalogue("chocolate", productName, searchQuery);
       if (product != null)
           return product;


       return null;
    }

    @Override
    public void print (Product forProduct, Customer customer) {
        System.out.println("Customer" + " " + super.firstName + " "
                + super.lastName +" " + "bought product.");
        System.out.println("@\t" + forProduct.price + "\tFully paid!");
    }

    static public void updateNumberOfPatronage () {

        Customer.numberOfPatronage += 1;
    }


}
