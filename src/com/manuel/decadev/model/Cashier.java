package com.manuel.decadev.model;



public class Cashier extends  Staff {

    final private short weeklyHour = 70;
    private static short allowableAbsentTimes = 2;

    public Cashier(int id, String firstName, String lastName, String department, String role) {
        super(id, firstName, lastName, department, role);

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
}
