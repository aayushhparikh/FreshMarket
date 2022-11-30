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

    Button cart2, signin3;
    TextView intent, intent2;
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

    }

    public void addData() {
        cartItems items1 = new cartItems("apple", 10, 0);
        cartItems items2 = new cartItems("oranges", 4, 0);

        myDb.insertCartData(items1);
        myDb.insertCartData(items2);
    }

        void StoreArrayData() {
            Cursor c = myDb.getALLCartItems();
            while (c.moveToNext()) {
                grocery_name2.add(c.getString(1));
            }
        }
    }