package com.manuel.decadev.model.threads;

import com.manuel.decadev.model.Customer;
import com.manuel.decadev.model.Product;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.util.ArrayList;
import java.util.List;

public class ProductThread implements Runnable {
List<Product> customerCart;
List<Product> productShelve;
Customer customer;
String choice;

public ProductThread(Customer customer, List<Product> productShelve, String choiceOfProd){
    //this.customerCart = cart;
    this.productShelve = productShelve;
    this.customer = customer;
    this.choice = choiceOfProd;

}


    private synchronized boolean addProdChoiceToCart()  {
        boolean match = false;
        System.out.println(" -->>> Product Thread running... : "+ Thread.currentThread().getName() );
        int initialQty;
        for (int i = 0; i < productShelve.size(); i += 1) {
            Product product = productShelve.get(i);

            initialQty = MainCatalogue.getStock().get(product.getName());
            if ((initialQty != 0 && product.getName().matches(choice) )|| product.getName().equals(choice)) {
                initialQty -= 1;
                match = true;
                customer.getCustomerCart().add(product);
                productShelve.remove(product);
                MainCatalogue.getStock().put(product.getName(), initialQty);
                return match;
            } else if (initialQty == 0){

                System.out.println("This product is out of stock");
                //throw new Exception("Out of stock Exception");
            }
        }

        return match;

    }

    @Override
    public void run() {

        addProdChoiceToCart();
        try {
            Thread.sleep(500);
        }catch (InterruptedException ie){
            System.out.println("Interruption happened");
        }
    }
}
