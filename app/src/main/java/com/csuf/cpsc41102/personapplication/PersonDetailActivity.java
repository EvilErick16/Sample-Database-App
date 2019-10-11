package com.csuf.cpsc41102.personapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;

public class PersonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        int personIndex = getIntent().getIntExtra("PersonIndex", 0);
        TextView tv = findViewById(R.id.display_id);

        //tv.setText("Details for person " + personIndex);
        Person pObj = PersonDB.getInstance().getPeople().get(personIndex);
        EditText fNameView = (EditText) findViewById(R.id.first_name_val_id);
        EditText lNameView = (EditText) findViewById(R.id.last_name_val_id);
        fNameView.setText(pObj.getFirstName());
        lNameView.setText(pObj.getLastName());


    }
}
