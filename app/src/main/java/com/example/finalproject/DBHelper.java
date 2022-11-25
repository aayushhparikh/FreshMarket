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

    //Column names
    public static final String col_id = "id";
    public static final String col_name = "groceryNames";
    public static final String col_price = "groceryPrice";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, factory, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + table_name + "(" +
                col_id + " Integer PRIMARY KEY AUTOINCREMENT," +
                col_name + " TEXT," +
                col_price + " number DEFAULT 0)" + ";";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table " + table_name + ";");
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

    public List<itemList> getAllItems() {
        List<itemList> itemLists = new ArrayList<itemList>();

        String query = "SELECT  * FROM " + table_name;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                itemList itemList = new itemList();
                itemList.setGroceryNames(c.getString(1));

                String name = c.getString(1);
            } while (c.moveToFirst());

        }
        return itemLists;
    }
}



