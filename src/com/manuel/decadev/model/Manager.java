package com.manuel.decadev.model;

public class Manager extends Staff{

    Cashier cashier;
    public Manager (int id, String firstName, String lastName, String department, String role){

        super(id,firstName, lastName, department, role);
    }

    public void issueQuery(Cashier cashier){
        cashier = new Cashier(1003, "Mary", "Daniel",
                "Marketing","Cashier");
        cashier.setAllowableAbsentTimes((short) (cashier.getAllowableAbsentTimes() - 1));

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


}
