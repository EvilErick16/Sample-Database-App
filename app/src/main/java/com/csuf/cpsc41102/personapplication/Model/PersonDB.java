package com.csuf.cpsc41102.personapplication.Model;

import java.util.ArrayList;

public class PersonDB {
    private static final PersonDB ourInstance = new PersonDB();

    protected ArrayList<Person> mPeople;

    static public PersonDB getInstance() {
        return ourInstance;
    }

    private PersonDB() {
    }

    public ArrayList<Person> getPeople() {
        return mPeople;
    }

    public void setPeople(ArrayList<Person> people) {
        mPeople = people;
    }
}
