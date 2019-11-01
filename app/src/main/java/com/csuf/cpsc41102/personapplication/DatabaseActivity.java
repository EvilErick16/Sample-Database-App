package com.csuf.cpsc41102.personapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;

public class DatabaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get path to database then open or create database
        File dbFile = this.getDatabasePath("test02.db");
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        // Create Person table if it doesn't exist - can omit IF NOT EXISTS in SQL if you use a try catch block
        db.execSQL("CREATE TABLE IF NOT EXISTS  Person(FirstName Text, LastName Text, SSN INTEGER)");

        // Create person entries and insert them to Person table - 3 examples here first record is deleted if it exists
        db.execSQL("DELETE FROM Person WHERE SSN=?", new String[]{"837776123"});
        db.execSQL("INSERT INTO Person VALUES ('James', 'Shen', 837776123)");

        db.execSQL("DELETE FROM Person WHERE SSN=?", new String[]{"778990123"});
        db.execSQL("INSERT INTO Person VALUES (?, ?, ?)", new String[]{"Mary", "Hsu", "778990123"});

        db.delete("Person", "SSN=?", new String[]{"998765134"});
        ContentValues vals = new ContentValues();
        vals.put("FirstName", "Jerry");
        vals.put("LastName", "Ramos");
        vals.put("SSN", 998765134);
        db.insert("Person", null, vals);

        // Query from database and store the result in cursor object
        Cursor cursor = db.query("Person", null, null, null,
                null, null, null);
        // Get first name and ssn from cursor object
        if (cursor.getCount() > 0 ){
            while (cursor.moveToNext()){
                String fName = cursor.getString(cursor.getColumnIndex("FirstName"));
                int ssn = cursor.getInt(cursor.getColumnIndex("SSN"));
                // Dump results to debug log
                Log.d("Database Log", fName + ":" + ssn);
            }
        }
        cursor.close();

        // Update Person table using 2 different methods
        db.execSQL("UPDATE Person SET FirstName= ? WHERE SSN=?", new String[]{"John", "837776123"});

        vals = new ContentValues();
        vals.put("FirstName", "Rudy");
        db.update("Person", vals, "SSN=?", new String[]{"998765134"});

        // Close database
        db.close();
    }
}
