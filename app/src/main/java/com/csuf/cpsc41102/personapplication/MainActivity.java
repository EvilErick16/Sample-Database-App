/*package com.csuf.cpsc41102.personapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.Vehicle;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createPersonObjects();
        setContentView(R.layout.person_summary);

        root = findViewById(R.id.person_summary);

        ArrayList<Person> personList = PersonDB.getInstance().getPeople();
        for (int i = 0; i < personList.size(); i++){
            Person p = personList.get(i);
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.person_row, root, false);
            TextView firstNameView = row_view.findViewById(R.id.first_name);
            firstNameView.setText(p.getFirstName());
            TextView lastNameView = row_view.findViewById(R.id.last_name);
            lastNameView.setText(p.getLastName());

            root.addView(row_view);
        }
    }

    protected void createPersonObjects() {
        Person p = new Person("James", "Shen");
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("999999", "Toyota", "Corolla"));
        vehicles.add(new Vehicle("999998", "Toyota", "Forerunner"));
        vehicles.add(new Vehicle("999997", "Honda", "Civic"));
        vehicles.add(new Vehicle("999996", "Honda", "Accord"));
        p.setVehicles(vehicles);
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(p);

        Person p1 = new Person("John", "Welch");
        ArrayList<Vehicle> vehicles1 = new ArrayList<Vehicle>();
        vehicles1.add(new Vehicle("999988", "Toyota", "Camry"));
        p1.setVehicles(vehicles1);
        personList.add(p1);

        PersonDB.getInstance().setPeople(personList);

    }
}
*/