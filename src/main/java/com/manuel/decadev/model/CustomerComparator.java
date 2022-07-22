package com.manuel.decadev.model;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1,Customer customer2) {

        int c1Qty = customer1.customerProdQty;
        int c2Qty = customer2.customerProdQty;

        if (c1Qty < c2Qty){
            return  1;
        } else if (c1Qty > c2Qty){
            return -1;
        } else {
            return  0;
        }

    }
}
