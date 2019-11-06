package com.csuf.cpsc41102.personapplication.Model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Person extends PersistentObject {

    // Data
    protected String mFirstName;
    protected String mLastName;
    protected ArrayList<Vehicle> mVehicles;
    protected int mSsn;


    // Constructor
    public Person(String firstName, String lastName, int ssn) {
        mFirstName = firstName;
        mLastName = lastName;
        mSsn = ssn;
    }

    public Person(){}

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

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues vals = new ContentValues();
        vals.put("FirstName", mFirstName);
        vals.put("LastName", mLastName);
        vals.put("SSN", mSsn);
        db.insert("Person", null, vals);

        for (int i = 0; i < mVehicles.size(); i++ ){
            mVehicles.get(i).insert(db);
        }
    }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Person (FirstName Text, LastName Text, SSN INTEGER)");
    }
}
