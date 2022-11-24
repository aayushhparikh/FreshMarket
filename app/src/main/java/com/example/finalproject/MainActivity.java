package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView items;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DBHelper(this, null, null, 1);

        addData();
    }

    public void addData(){
        itemList item1 = new itemList("apple", 10);
        itemList item2= new itemList("oranges", 4);

        myDb.insertData(item1);
        myDb.insertData(item2);
    }
}