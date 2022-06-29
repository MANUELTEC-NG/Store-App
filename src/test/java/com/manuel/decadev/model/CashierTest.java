package com.manuel.decadev.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest extends Staff {

    public CashierTest(String firstName, String lastName, String gender, String department, String role, int id) {
        super(firstName, lastName, gender, department, role, id);
    }


    @BeforeEach
    void setUp() {
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


    @Test
    void testSetRole1() {
    }
}