package com.manuel.decadev.model;

public class CusBankAccount {

    private double bankBalance = 0;
    private String customerFName = "";
    private String customerLastName = "";
    private String phone = "";


    public CusBankAccount(String customerFName, String customerLastName, double bankBalance) {
        this.bankBalance = bankBalance;
        this.customerFName = customerFName;
        this.customerLastName = customerLastName;
        this.phone = phone;
    }

    public CusBankAccount(){
        this("Sure", "Customer", 50000.00);
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
