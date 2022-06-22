package com.manuel.decadev;

import com.manuel.decadev.model.Cashier;
import com.manuel.decadev.model.Manager;
import com.manuel.decadev.model.Product;
import com.manuel.decadev.model.ProductCataloque.Biscuit;
import com.manuel.decadev.model.ProductCataloque.Gala;

import java.util.ArrayList;

public class Store {


    public static void main(String[] args) {
	// write your code

        Manager aManager = new Manager(2002,"Master", "Java",
                "Engineering Department", "Manager");

        String selfIntro = "My name Is" + " "+aManager.getFirstName()+
                " "+ aManager.getLastName()+ "." + "A" +" "+aManager.getRole() +" "+"In the"+" "+aManager.getDepartment()+" "
                + "In"+" " + Manager.getCompanyName();
        Cashier mary = new Cashier(1003, "Mary", "Daniel",
                "Marketing","Cashier");

        aManager.issueQuery(mary);



        System.out.println(selfIntro);

    }
}
