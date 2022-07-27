package com.manuel.decadev.model.threads;

import com.manuel.decadev.model.Cashier;
import com.manuel.decadev.model.Customer;

public class SellThread {
public Cashier cashierInstance;
Customer customerInstance;
public SellThread(Cashier cashier, Customer customer){
    cashierInstance = cashier;
    customerInstance = customer;
}
   public Runnable runnable = ()->{
        try {
            System.out.println(" -->>> Sell Thread running: " + Thread.currentThread().getName());

            cashierInstance.sellProduct(customerInstance.currentProduct , customerInstance.prodCategory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };



}
