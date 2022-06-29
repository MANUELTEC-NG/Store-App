package com.manuel.decadev.model;

public abstract class Staff extends Person {

private int id = 0;
final static String companyName = "Decagon Convenience Store";
private String role = "";
private short durationWithComp = 0;
private String department = "";


public Staff(String firstName, String lastName,String gender, String department, String role, int id){

    super(firstName, lastName, gender);
    this.id = id;
    this.department = department;
    this.role = role;
}

//public void setGender (String gender){
//    super.gender = gender;
//}

public abstract void stateGender(String gender);
public abstract boolean canWorkOverTime();
public abstract boolean isBonafideStaff(Staff staff);
public void setRole(String role){
    this.role = role;
}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return super.firstName;
    }

    public String getLastName() {
        return super.lastName;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDurationWithComp(short durationWithComp) {
        this.durationWithComp = durationWithComp;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
