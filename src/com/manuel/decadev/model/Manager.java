package com.manuel.decadev.model;

public class Manager extends Staff{

    Cashier cashier;
    public Manager (int id, String firstName, String lastName, String department, String role){

        super(id,firstName, lastName, department, role);
    }

    public void issueQuery(Cashier cashier){
        cashier.setAllowableAbsentTimes((short) (cashier.getAllowableAbsentTimes() - 1));
        outputHelperMethod("Query sent to" + " " + cashier.getFirstName() + " " + cashier.getLastName());
        outputHelperMethod("You have" + " " + cashier.getAllowableAbsentTimes()+ " " + "warning left before being fired");

    }



    @Override
    public boolean canWorkOverTime(){
    if(cashier.getRole().equals("Cashier") && (cashier.getAllowableAbsentTimes() < 2))
        return true;
    return false;
    }

    @Override
    public void stateGender(String gender) {
        System.out.println(gender);
    }

    public void holdMeeting(){

    }

    public void outputHelperMethod(String msg){
        System.out.println(msg);
    }
}
