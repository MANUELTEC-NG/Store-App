package com.manuel.decadev.model;

import com.manuel.decadev.model.ProductCataloque.Biscuit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest extends Staff {
    private static Cashier mary;
    private static ArrayList<Biscuit> biscuits;

    public ManagerTest(String firstName, String lastName, String gender, String department, String role, int id) {
        super(firstName, lastName, gender, department, role, id);
    }

    @BeforeEach
    void setUp() {
        Manager aManager = new Manager("Olu","Master", "Male",
                "Engineering Department", "Store Manager", 10034);

        Customer customer = new Customer("Sylva", "Dodo","Female",
                "something@gmail.com", 234-421-494);

       Cashier  mary = new Cashier("Daniel", "Mary", "Sales Department",
                "Cashier", "Female", 5032);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSetRole() {
    }

    @Test
    void testGetId() {
    }

    @Test
    void testGetFirstName() {
    }

    @Test
    void testGetLastName() {
    }

    @Test
    void testGetCompanyName() {
    }

    @Test
    void testGetRole() {
    }

    @Test
    void testGetDurationWithComp() {
    }

    @Test
    void testGetDepartment() {
    }

    @Test
    void testGetGender() {
    }

    @Test
    void testSetGender() {
    }

    @Test
    void testSetId() {
    }

    @Test
    void testSetFirstName() {
    }

    @Test
    void testSetLastName() {
    }

    @Test
    void testSetDurationWithComp() {
    }

    @Test
    void testSetDepartment() {
    }

    @Test
    void issueQuery() {
    }

    @Test
    void hireCashier() {
    }

    @Test
    void fireEmployee() {
    }

    @Test
    void testCanWorkOverTime() {
    }

    @Test
    void testIsBonafideStaff() {
    }

    @Test
    void testStateGender() {
    }

    @Test
    void holdMeeting() {
    }

    @Override
    public void stateGender(String gender) {

    }

    @Override
    public boolean canWorkOverTime() {
        return false;
    }

    @Override
    public boolean isBonafideStaff(Staff staff) {
        return false;
    }
}