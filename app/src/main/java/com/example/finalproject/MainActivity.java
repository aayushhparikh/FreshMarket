package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    Button cart, signin;

    ArrayList<String> grocery_name;

    GridView items;
    DBHelper myDb;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);


        cart = findViewById(R.id.cart);
        signin = findViewById(R.id.signin2);

        myDb = new DBHelper(this, null, null, 1);
        grocery_name = new ArrayList<>();

        StoreArrayData();

        adapter = new Adapter(MainActivity.this, this, grocery_name);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cart.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }

    void StoreArrayData() {
        Cursor c = myDb.getAllItems();
        while (c.moveToNext()) {
            grocery_name.add(c.getString(1));
        }
    }

    public void addData(){
        itemList item1 = new itemList("apple", 10);
        itemList item2= new itemList("oranges", 4);

        myDb.insertData(item1);
        myDb.insertData(item2);
    }

}