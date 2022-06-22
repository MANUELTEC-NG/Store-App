package com.manuel.decadev.model;

public abstract class Staff {

private int id = 0;
private String firstName = "";
private String lastName = "";
final static String companyName = "Decagon Student Convenience Store";
private String role = "";
private short durationWithComp = 0;
private String department = "";
private String gender = "";

public Staff(int id, String firstName, String lastName,String department, String role){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
    this.role = role;
}

public Staff(String gender){
    this.gender = gender;
}

public abstract void stateGender(String gender);
public abstract boolean canWorkOverTime();
public void setRole(String role){
    this.role = role;
}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public String getRole() {
        return this.role;
    }

    public short getDurationWithComp() {
        return durationWithComp;
    }

    public String getDepartment() {
        return department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
