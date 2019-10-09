package com.csuf.cpsc41102.personapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;
import com.csuf.cpsc41102.personapplication.R;

public class SummaryLVAdapter extends BaseAdapter {

    protected int count = 0;

    @Override
    public int getCount() {
        return PersonDB.getInstance().getPeople().size();
    }
    @Override
    public Object getItem(int i) {
        return PersonDB.getInstance().getPeople().get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null){
            count++;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
        }
        else
            row_view = view;

        Person p = PersonDB.getInstance().getPeople().get(i);
        TextView firstNameView = row_view.findViewById(R.id.first_name);
        firstNameView.setText(p.getFirstName());
        TextView lastNameView = row_view.findViewById(R.id.last_name);
        lastNameView.setText(p.getLastName());
        return null;

    }
}
