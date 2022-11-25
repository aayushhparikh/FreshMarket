package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> Arrayofname = new ArrayList<String>();

    GridView items;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DBHelper(this, null, null, 1);

        readItems();
        addData();

        myDb.getAllItems();

        items = (GridView) findViewById(R.id.itemsGrid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrayofname);

        items.setAdapter(adapter);
    }

    public void readItems() {
        List<itemList> itemLists = myDb.getAllItems();

    }

    public void addData(){
        itemList item1 = new itemList("apple", 10);
        itemList item2= new itemList("oranges", 4);

        myDb.insertData(item1);
        myDb.insertData(item2);
    }
}