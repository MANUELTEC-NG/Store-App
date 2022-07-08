package com.manuel.decadev.model;


import com.manuel.decadev.model.Interface.IPrint;
import com.manuel.decadev.model.ProductCataloque.MainCatalogue;

import java.util.ArrayList;

public class Cashier extends  Staff implements IPrint <Product, Customer>{

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;
    private int workExperience = 0;

    public Cashier(String firstName, String lastName, String department, String role, String gender, int compId) {
        super(firstName,lastName, gender, department, role, compId);

    }

    public Cashier(){
        super();
    }

    public void sellProduct (Customer toCustomer, Product purchasedProduct){
        // TODO
        // Implement the logic of cashier withdrawing money from customer's account
        // and removing product from catalogue
        Product product = toCustomer.purchaseProduct(purchasedProduct.name, purchasedProduct.manufacturer);


    }

    public void receiveProductPayment( Customer customer, String product ){


    }

    @Override
    public void print(Product item, Customer customer){

        String desc = item.price + " " + item.manufacturer;
        System.out.println("Cashier Printing Receipt for Customer");
        System.out.println("________________________________________________________");
        System.out.println("Customer Bought a Product");
        System.out.println(desc);
    }

    @Override
    public void stateGender(String gender){
        setGender(gender);
    }

    @Override
    public boolean canWorkOverTime(){

        return true;
    }

    public void setAllowableAbsentTimes(short allowableAbsentTimes) {
        this.allowableAbsentTimes = allowableAbsentTimes;
    }

    public short getWeeklyHour() {
        return weeklyHour;
    }

    public short getAllowableAbsentTimes() {
        return allowableAbsentTimes;
    }

    @Override
    public String getRole() {
        return super.getRole();
    }



    @Override
    public boolean isBonafideStaff(Staff staff){
        Cashier cashier = (Cashier) staff;
        boolean bonafide = false;
        int id = cashier.getId();
        String firstName = cashier.getFirstName();
        String lastName = cashier.getLastName();
        if( id != 0 && firstName != "" && lastName != "" ){
            bonafide = true;
            return bonafide;
        }

        return bonafide;
    }

    public int setWorkExperience(int years){
        return this.workExperience = years;
    }


    public int retrieveWorkExperience() {
        return workExperience;
    }

    private void removeProductFromCatalogue(Product product){
        ArrayList<Product> catalogue = MainCatalogue.sendProdCatalogue();
        int size = catalogue.size();
        int i = 0;

        while (i < size){
            Product p = catalogue.get(i);
            if (p.name.equals(product.name)){
                catalogue.remove(product);
                // TODO
                // check if true

            }


            i++;
        }
    }
}
