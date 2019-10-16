package com.csuf.cpsc41102.personapplication.Model;

import java.util.ArrayList;

public class PersonDB {
    private static final PersonDB ourInstance = new PersonDB();

    protected ArrayList<Person> mPeople;

    private PersonDB() {
        //createPersonObjects();
    }

    static public PersonDB getInstance() {
        return ourInstance;
    }

    public ArrayList<Person> getPeople() {
        return mPeople;
    }

    public void setPeople(ArrayList<Person> people) {
        mPeople = people;
    }

    /*
    protected void createPersonObjects() {
        ArrayList<Person> personList = new ArrayList<Person>();

        Person p = new Person("James", "Shen");
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("999999", "Toyota", "Corolla"));
        vehicles.add(new Vehicle("9999998", "Lexus", "LFA"));
        p.setVehicles(vehicles);
        personList.add(p);

        Person p1 = new Person("John", "Welch");
        ArrayList<Vehicle> vehicles1 = new ArrayList<Vehicle>();
        vehicles1.add(new Vehicle("999988", "Toyota", "Camry"));
        p1.setVehicles(vehicles1);
        personList.add(p1);

        PersonDB.getInstance().setPeople(personList);
    } */
}
