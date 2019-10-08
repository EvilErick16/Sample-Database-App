package com.csuf.cpsc41102.personapplication.Model;

public class Vehicle {
    protected String mVin;
    protected String mMake;
    protected String mModel;

    public Vehicle(String vin, String make, String model) {
        mVin = vin;
        mMake = make;
        mModel = model;
    }

    public String getVin() {
        return mVin;
    }

    public void setVin(String vin) {
        mVin = vin;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }
}
