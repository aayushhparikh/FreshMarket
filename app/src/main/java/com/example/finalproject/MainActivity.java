package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = findViewById(R.id.itemsGrid);
        ArrayList<itemList> itemListArrayList = new ArrayList<itemList>();

        itemListArrayList.add(new itemList("Apples"));
        itemListArrayList.add(new itemList("Oranges"));
        itemListArrayList.add(new itemList("Bananas"));
        itemListArrayList.add(new itemList("Pear"));
        itemListArrayList.add(new itemList("Watermelon"));
        itemListArrayList.add(new itemList("Avacado"));

        ItemAdapter adapter = new ItemAdapter(this, itemListArrayList);
        items.setAdapter(adapter);
    }
}