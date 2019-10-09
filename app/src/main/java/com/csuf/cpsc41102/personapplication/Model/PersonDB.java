package com.csuf.cpsc41102.personapplication.Model;

import java.util.ArrayList;

public class PersonDB {
    private static final PersonDB ourInstance = new PersonDB();

    protected ArrayList<Person> mPeople;

    private PersonDB() {
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
}
