package com.manuel.decadev.model;

import com.manuel.decadev.model.Handlers.PrintHandler;

public class Manager extends Staff{


    Cashier cashier;
    public Manager (int id, String firstName, String lastName, String department, String role){

        super(id,firstName, lastName, department, role);
    }

    public void issueQuery(Cashier cashier){
        short warning = cashier.getAllowableAbsentTimes();
        short remainingWarning = (short) (warning- 1);
        cashier.setAllowableAbsentTimes((remainingWarning));

        PrintHandler.outputHelperMethod("Query sent to" + " " + cashier.getFirstName() + " " + cashier.getLastName());
        PrintHandler.outputHelperMethod("You have" + " " + cashier.getAllowableAbsentTimes()+ " " +
                "warning left before being fired");

    }

    public boolean fireEmployee(Cashier cashier, String resetFirst,
                                String resetLastName, int resetId){
        boolean bonafide = cashier.isBonafideStaff(cashier);
        if (!bonafide) {
            short warn = cashier.getAllowableAbsentTimes();
            if (warn > 0) {
                cashier.resetCashierData(resetFirst, resetLastName, resetId);
                PrintHandler.outputHelperMethod("..................................");
                PrintHandler.outputHelperMethod("A Cashier got fired Last Week. Record reset!");
                String newRecord = cashier.getId() + " " + cashier.getFirstName() + " " + cashier.getLastName();
                System.out.println( newRecord +"Record with us! ");

                return true;

            }
        }
        return false;
    }

    @Override
    public boolean canWorkOverTime(){
    if(cashier.getRole().equals("Cashier") && (cashier.getAllowableAbsentTimes() < 2))
        return true;
    return false;
    }

    @Override
    public boolean isBonafideStaff(Staff staff) {
        return false;
    }

    @Override
    public void stateGender(String gender) {
        System.out.println(gender);
    }

    public void holdMeeting(){

    }


}
