package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    Button cart2, signin3;
    TextView intent, intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SharedPrefs.init(getApplicationContext());

        cart2 = findViewById(R.id.cart2);
        signin3 = findViewById(R.id.signin3);
        intent = findViewById(R.id.intent);
        intent2 = findViewById(R.id.intent2);

        ArrayList<String> arrayList = new ArrayList<String>();


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

        String StoredValue = SharedPrefs.getString("items", "");

        String val = StoredValue;

        arrayList.add(StoredValue);

        intent.setText(arrayList.get(0));
    }
}