package com.example.myapplication.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Products (VIN INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, price DOUBLE, img INT, imglink TEXT)";

    public ProductSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Products");

        db.execSQL(sqlCreate);
    }
}
