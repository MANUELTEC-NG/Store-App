package com.manuel.decadev.model;

public abstract class Person {
    protected String firstName = "";
    protected String lastName = "";
    protected String gender = "";

    public Person(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person(){}
}
