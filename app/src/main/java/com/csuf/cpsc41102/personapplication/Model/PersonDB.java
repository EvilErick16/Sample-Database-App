package com.csuf.cpsc41102.personapplication.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class PersonDB {
    //private static final PersonDB ourInstance = new PersonDB();

    protected ArrayList<Person> mPeople;

    SQLiteDatabase mSQLiteDatabase;

    public PersonDB(Context context) {
        File dbFile = context.getDatabasePath("person.db");
        mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        // Create Person and Vehicle tables if necessary
        new Person().createTable(mSQLiteDatabase);
        new Vehicle().createTable(mSQLiteDatabase);

        createPersonObjects();
    }

    /*static public PersonDB getInstance() {
        return ourInstance;
    }*/

    public ArrayList<Person> getPeople() {
        return mPeople;
    }

    public void setPeople(ArrayList<Person> people) {
        mPeople = people;
    }


    protected void createPersonObjects() {
        mPeople = new ArrayList<Person>();

        Person p = new Person("James", "Bond", 8901234);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("999999", "Toyota", "Corolla", 8901234));
        vehicles.add(new Vehicle("9999998", "Lexus", "LFA", 8901234));
        p.setVehicles(vehicles);
        mPeople.add(p);
        p.insert(mSQLiteDatabase);

        Person p1 = new Person("John", "Elders", 8881234);
        ArrayList<Vehicle> vehicles1 = new ArrayList<Vehicle>();
        vehicles1.add(new Vehicle("999988", "Toyota", "Camry", 8881234));
        p1.setVehicles(vehicles1);
        mPeople.add(p1);
        p1.insert(mSQLiteDatabase);

        //PersonDB.getInstance().setPeople(personList);
    }
}
