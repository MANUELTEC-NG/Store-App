package com.manuel.decadev.model;


import javax.lang.model.type.NullType;

public class Cashier extends  Staff {

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;

    public Cashier(String firstName, String lastName, String department, String role, String gender, int compId) {
        super(firstName,lastName, gender, department, role, compId);

    }

    public void sell (Customer customer){
        // TODO
        // Implement the logic of cashier withdrawing money from customer's account
        // and removing product from catalogue
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
    public void resetCashierData(String resetFirst,
                                 String resetLastName, int resetId){
       super.setId(resetId);
       this.setFirstName(resetFirst);
       this.setLastName(resetLastName);

    }

    @Override
    public boolean isBonafideStaff(Staff staff){
        Cashier cashier = (Cashier) staff;
        return cashier.getId() == 0 &&
                (cashier.getFirstName().equals("")) && cashier.getLastName().equals("");
    }
}
