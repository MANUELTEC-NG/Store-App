package com.manuel.decadev.model;

public abstract class Staff {

public int id = 0;
public String firstName = "";
public String lastName = "";
final static String companyName = "Decagon Student Convenience Store";
public String role = "";
public short durationWithComp = 0;
public String department = "";
public String gender = "";

public Staff(int id, String firstName, String lastName,String department, String role){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
    this.role = department;
}

public abstract void stateGender(String gender);
public abstract boolean canWorkOverTime();
public void setRole(String role){
    this.role = role;
}


}
