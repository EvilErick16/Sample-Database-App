package com.csuf.cpsc41102.personapplication.Model;

import android.content.Context;
import android.database.Cursor;
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

        //createPersonObjects();
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

    public ArrayList<Person> retrievePersonObjects(){
        mPeople = new ArrayList<>();
        Cursor cursor = mSQLiteDatabase.query("Person", null,null, null, null, null, null);
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Person pObj = new Person();
                pObj.initFrom(mSQLiteDatabase, cursor);
                mPeople.add(pObj);
            }
        }
        return mPeople;
    }


    protected void createPersonObjects() {
        mPeople = new ArrayList<Person>();

        mSQLiteDatabase.execSQL("DELETE FROM Person WHERE SSN=?", new String[]{"890"});
        mSQLiteDatabase.execSQL("DELETE FROM Person WHERE SSN=?", new String[]{"891"});
        Person p = new Person("James", "Bond", 890);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("999999", "Toyota", "Corolla", 890));
        vehicles.add(new Vehicle("9999998", "Lexus", "LFA", 890));
        p.setVehicles(vehicles);
        mPeople.add(p);
        p.insert(mSQLiteDatabase);

        Person p1 = new Person("John", "Elders", 891);
        ArrayList<Vehicle> vehicles1 = new ArrayList<Vehicle>();
        vehicles1.add(new Vehicle("999988", "Toyota", "Camry", 891));
        p1.setVehicles(vehicles1);
        mPeople.add(p1);
        p1.insert(mSQLiteDatabase);

        //PersonDB.getInstance().setPeople(personList);
    }
}
