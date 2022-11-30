package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    Button cart2, signin3, clear;
    RecyclerView recyclerView2;
    ArrayList<String> grocery_name2;

    DBHelper myDb;
    private CartAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart2 = findViewById(R.id.cart2);
        signin3 = findViewById(R.id.signin3);
        clear = findViewById(R.id.clear);

        recyclerView2 = findViewById(R.id.recyclerview2);
        myDb = new DBHelper(this, null, null, 1);
        grocery_name2 = new ArrayList<>();

        //addData();

        StoreArrayData();

        adapter2 = new CartAdapter(Cart.this, this, grocery_name2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(Cart.this));

        cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, LoginPage.class);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.deleteCartItems();
                Intent intent = new Intent(Cart.this, Cart.class);
                startActivity(intent);
            }
        });

    }

        void StoreArrayData() {
            Cursor c = myDb.getALLCartItems();
            while (c.moveToNext()) {
                grocery_name2.add(c.getString(1));
            }
        }
    }