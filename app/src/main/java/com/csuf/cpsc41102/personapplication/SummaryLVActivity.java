package com.csuf.cpsc41102.personapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.csuf.cpsc41102.personapplication.Model.Person;
import com.csuf.cpsc41102.personapplication.Model.PersonDB;
import com.csuf.cpsc41102.personapplication.Model.Vehicle;
import com.csuf.cpsc41102.personapplication.adapter.SummaryLVAdapter;

import java.util.ArrayList;

public class SummaryLVActivity extends Activity {

    protected ListView mSummaryView;
    protected final String TAG = "Summary Screen";
    protected SummaryLVAdapter ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "OnCreate() called");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.summary_list_view);

        mSummaryView = findViewById(R.id.summary_list_view_id);
        ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "OnResume() called");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "OnDestroy() called");
        super.onDestroy();
    }
}
