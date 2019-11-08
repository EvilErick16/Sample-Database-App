package com.csuf.cpsc41102.personapplication.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Vehicle extends PersistentObject {
    protected String mVin;
    protected String mMake;
    protected String mModel;
    protected int mSsn;

    public Vehicle(String vin, String make, String model, int ssn) {
        mVin = vin;
        mMake = make;
        mModel = model;
        mSsn = ssn;
    }

    public Vehicle(){}

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

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues vals = new ContentValues();
        vals.put("VIN", mVin);
        vals.put("Make", mMake);
        vals.put("Model", mModel);
        vals.put("Owner", mSsn);
        db.insert("Person", null, vals);
    }

    @Override
    public void initFrom(SQLiteDatabase db, Cursor c) {
        mVin = c.getString(c.getColumnIndex("VIN"));
        mMake = c.getString(c.getColumnIndex("Make"));
        mModel = c.getString(c.getColumnIndex("Model"));
        mSsn = c.getInt(c.getColumnIndex("Owner"));
    }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Vehicle (VIN Text, Make Text, Model Text, Owner INTEGER)");
    }
}
