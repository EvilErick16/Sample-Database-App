package com.csuf.cpsc41102.personapplication.Model;

import java.util.ArrayList;

public class Person {

    // Data
    protected String mFirstName;
    protected String mLastName;
    protected ArrayList<Vehicle> mVehicles;


    // Constructor
    public Person(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }


    // Getter and Setter Methods
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public ArrayList<Vehicle> getVehicles() {
        return mVehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        mVehicles = vehicles;
    }
}
