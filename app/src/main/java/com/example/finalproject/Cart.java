package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private Button cart2, signin3, clear, add, subtract, checkout;
    private TextView price;
    private RecyclerView recyclerView2;
    private ArrayList<String> grocery_name2;
    private ArrayList<Integer> quantities;
    private ArrayList<Double> price_num2;
    private double sum = 0;

    // int quantity_num;

    DBHelper myDb;
    private CartAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPrefs.init(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart2 = findViewById(R.id.cart2);
        signin3 = findViewById(R.id.signin3);
        clear = findViewById(R.id.clear);
        subtract = findViewById(R.id.minus1);
        add = findViewById(R.id.add1);
        price = findViewById(R.id.price);
        checkout = findViewById(R.id.checkout);

        recyclerView2 = findViewById(R.id.recyclerview2);
        myDb = new DBHelper(this, null, null, 1);
        grocery_name2 = new ArrayList<>();
        price_num2  = new ArrayList<>();
        quantities = new ArrayList<>();

        //addData();

        //calling store array data to store db values into array
        StoreArrayData();
        StorePriceData();
        StoreQuantityData();

        updatePrice();

        checkPrice();



//        StoreQuantityData(i);

        adapter2 =new CartAdapter(Cart.this, this, grocery_name2, price_num2, quantities, this::add1, this::minus1);
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

                grocery_name2.clear();
                price_num2.clear();
                quantities.clear();
                Intent intent = new Intent(Cart.this, Cart.class);
                startActivity(intent);
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, MapActivity.class);
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

    void StorePriceData() {
        Cursor c = myDb.getALLCartItems();
        while (c.moveToNext()) {
            price_num2.add(c.getDouble(2));
        }
    }

    void StoreQuantityData() {
        Cursor c = myDb.getALLCartItems();
        while (c.moveToNext()) {
            quantities.add(c.getInt(3));
        }
    }

    public void minus1(View view, int position, int quantity){
        myDb.updateCartItems(position, quantity);
        updatePrice();
        checkPrice();
    }

    public void add1(View view, int position, int quantity) {
        myDb.updateCartItems(position, quantity);
        updatePrice();
        checkPrice();
    }

    public void checkPrice(){
        if (sum > 0) {
            checkout.setClickable(true);
        } else {
            checkout.setClickable(false);
            Toast.makeText(getApplicationContext(), "Please add something to cart", Toast.LENGTH_LONG).show();
        }

    }

    public void updatePrice(){
        sum = 0;
        for(int i=0;i < price_num2.size();i++){
            sum += price_num2.get(i) * quantities.get(i);

            price.setText(String.format("$%.2f", sum));
            SharedPrefs.putString("sum","" + sum);
        }
    }
}