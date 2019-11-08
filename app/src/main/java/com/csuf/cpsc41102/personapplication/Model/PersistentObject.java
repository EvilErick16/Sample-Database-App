package com.csuf.cpsc41102.personapplication.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class PersistentObject {
    public abstract void insert(SQLiteDatabase db);
    public abstract void createTable(SQLiteDatabase db);
    public abstract void initFrom(SQLiteDatabase db, Cursor c);
}
