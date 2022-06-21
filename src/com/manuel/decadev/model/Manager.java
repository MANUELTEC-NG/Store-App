package com.manuel.decadev.model;

public class Manager extends Staff{

    Cashier cashier;
    public Manager (int id, String firstName, String lastName, String department, String role){

        super(id,firstName, lastName, department, role);
    }

    public void issueQuery(Cashier cashier){

    }

    @Override
    public boolean canWorkOverTime(){

        return false;
    }

    @Override
    public void stateGender(String gender) {

    }


}
