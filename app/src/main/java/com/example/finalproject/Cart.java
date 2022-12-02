package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    Button cart2, signin3, clear, add, subtract;
    TextView price;
    RecyclerView recyclerView2;
    ArrayList<String> grocery_name2;
    ArrayList<Double> quantity_id;
    ArrayList<Double> price_num2;

    int i;

    DBHelper myDb;
    private CartAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart2 = findViewById(R.id.cart2);
        signin3 = findViewById(R.id.signin3);
        clear = findViewById(R.id.clear);
        add = findViewById(R.id.add1);
        subtract = findViewById(R.id.minus1);
        price = findViewById(R.id.price);

        recyclerView2 = findViewById(R.id.recyclerview2);
        myDb = new DBHelper(this, null, null, 1);
        grocery_name2 = new ArrayList<>();
        price_num2  = new ArrayList<>();
        quantity_id = new ArrayList<>();

        //addData();

        //calling store array data to store db values into array
        StoreArrayData();
        StorePriceData();
        StoreQuantityData();

        updatePrice();

//        StoreQuantityData(i);

        adapter2 = new CartAdapter(Cart.this, this, grocery_name2, price_num2, quantity_id, this::add1, this::minus1);
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
                quantity_id.clear();
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

        void StorePriceData() {
            Cursor c = myDb.getALLCartItems();
            while (c.moveToNext()) {
                price_num2.add(c.getDouble(2));
            }
        }

        void StoreQuantityData() {
            Cursor c = myDb.getALLCartItems();
            while (c.moveToNext()) {
                quantity_id.add(c.getDouble(3));
            }
        }

        public void add1(View view, int position) {
            myDb.updateCartItems(50 + quantity_id.get(position), i++);
            Toast.makeText(getApplicationContext(), "add 1", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Cart.this, Cart.class);
            startActivity(intent);
        }


    public void minus1(View view, int position){
            Toast.makeText( getApplicationContext(), "Subtract 1", Toast.LENGTH_SHORT).show();

        }

    public void updatePrice(){
        double sum = 0;
        int i;
        for(i=0;i < price_num2.size();i++){
            sum = sum+(price_num2.get(i));

            price.setText("Price = " + sum);
        }
    }



    }