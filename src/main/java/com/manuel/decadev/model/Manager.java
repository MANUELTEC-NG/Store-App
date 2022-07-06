package com.manuel.decadev.model;

import com.manuel.decadev.Store;
import com.manuel.decadev.model.Handlers.PrintHandler;

import java.util.ArrayList;

public class Manager extends Staff {

    static ArrayList<Cashier> cashiers = new ArrayList<>();
    Cashier cashier;
    public Manager (String firstName, String lastName, String gender, String department, String role, int compId){

        super(firstName, lastName, gender, department, role, compId);
    }

    public void issueQuery(Cashier cashier){
        short warning = cashier.getAllowableAbsentTimes();
        short remainingWarning = (short) (warning- 1);
        cashier.setAllowableAbsentTimes((remainingWarning));

        PrintHandler.outputHelperMethod("Query sent to" + " " + cashier.getFirstName() + " " + cashier.getLastName());
        PrintHandler.outputHelperMethod("You have" + " " + cashier.getAllowableAbsentTimes()+ " " +
                "warning left before being fired");

    }

    public boolean hireCashier(String fName, String lName, int compId){
    Cashier damilola = new Cashier(fName, lName, this.getDepartment(),
            "Cashier", "Female", compId);

     int workExp = damilola.retrieveWorkExperience() == 0 ? damilola.setWorkExperience(2): damilola.retrieveWorkExperience();

     if (workExp > 0) {
         cashiers.add(damilola);
         // TODO
         // Assert Non Null here
         return true;
     }
        return false;
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
