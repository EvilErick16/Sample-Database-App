package com.csuf.cpsc41102.personapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;
import com.csuf.cpsc41102.personapplication.Model.Vehicle;
import com.csuf.cpsc41102.personapplication.adapter.SummaryLVAdapter;

import java.util.ArrayList;

public class SummaryLVActivity extends Activity {
    protected ListView mSummaryView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_list_view);

        createPersonObjects();
        mSummaryView = findViewById(R.id.summary_list_view_id);
        SummaryLVAdapter ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

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

    }
}
