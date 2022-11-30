package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    //DB info
    public static final String DBNAME = "finalproject.db";
    public static final int dbversion = 1;

    //table name
    public static final String table_name = "groceryItems";
    public static final String table_name2 = "groceryCart";

    //Column names
    public static final String col_id = "id";
    public static final String col_name = "groceryNames";
    public static final String col_price = "groceryPrice";

    //Column names for cart
    public static final String col_id2 = "id";
    public static final String col_name2 = "groceryNames2";
    public static final String col_price2 = "groceryPrice2";
    public static final String col_quantity = "groceryQuantitynumber";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table 1
        String createTable = "CREATE TABLE " + table_name + "(" +
                col_id + " Integer PRIMARY KEY AUTOINCREMENT," +
                col_name + " TEXT," +
                col_price + " number DEFAULT 0)" + ";";

        //create table 2
        String createTable2 = "CREATE TABLE " + table_name2 + "(" +
                col_id2 + " Integer PRIMARY KEY AUTOINCREMENT," +
                col_name2 + " TEXT," +
                col_price2 + " number DEFAULT 0, " +
                col_quantity + "number DEFAULT 0) " + ";";

        //create tables
        db.execSQL(createTable);
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table " + table_name + ";");
        db.execSQL("drop table " + table_name2 + ";");


    }

    public void insertData(itemList itemList) {
        ContentValues values = new ContentValues();
        values.put(col_name, itemList.getGroceryNames());
        values.put(col_price, itemList.getGroceryPrice());

        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.insert(table_name, null, values);
        } finally {
            db.close();
        }

    }

    public void insertCartData(cartItems cartItems) {
        ContentValues values = new ContentValues();
        values.put(col_name2, cartItems.getGroceryNames2());
        values.put(col_price2, cartItems.getGroceryPrice2());
        values.put(col_quantity, cartItems.getGroceryQuantitynumber());

        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.insert(table_name2, null, values);
        } finally {
            db.close();
        }
    }

    Cursor getALLCartItems(){
        String query = "SELECT * FROM " + table_name2;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = null;
        if(db != null) {
            c = db.rawQuery(query, null);
        }
        return c;
    }

    Cursor getAllItems() {
        String query = "SELECT * FROM " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = null;
        if(db != null) {
            c = db.rawQuery(query, null);
        }
        return c;
    }

    public void deleteItems(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name, null, null);
        db.close();
    }

    public void deleteCartItems(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name2, null, null);
        db.close();
    }

}



