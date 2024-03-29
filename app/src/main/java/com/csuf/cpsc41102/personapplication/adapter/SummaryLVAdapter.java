package com.csuf.cpsc41102.personapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;
import com.csuf.cpsc41102.personapplication.PersonDetailActivity;
import com.csuf.cpsc41102.personapplication.R;

public class SummaryLVAdapter extends BaseAdapter {

    private PersonDB mPersonDB;
    public SummaryLVAdapter(Context context){
        mPersonDB = new PersonDB(context);
        mPersonDB.retrievePersonObjects();
    }

    @Override
    public int getCount() {
        return mPersonDB.getPeople().size();
    }
    @Override
    public Object getItem(int i) {
        return mPersonDB.getPeople().get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
        }
        else row_view = view;

        Person p = mPersonDB.getPeople().get(i);

        TextView firstNameView = row_view.findViewById(R.id.first_name);
        firstNameView.setText(p.getFirstName());
        TextView lastNameView = row_view.findViewById(R.id.last_name);
        lastNameView.setText(p.getLastName());
        row_view.setTag(new Integer(i));

        row_view.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PersonDetailActivity.class);
                intent.putExtra("PersonIndex", ((Integer)view.getTag()).intValue());
                view.getContext().startActivity(intent);
            }
        });
        return row_view;
    }
}
