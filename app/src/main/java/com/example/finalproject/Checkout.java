package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    TextView sum, timee, date;
    String total, time, datee;
    Button completeOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        sum = findViewById(R.id.sum);
        timee = findViewById(R.id.timee);
        date = findViewById(R.id.date);
        completeOrder = findViewById(R.id.completeOrder);

        SharedPrefs.init(getApplicationContext());

        total = SharedPrefs.getString("sum", "");
        time = SharedPrefs.getString("time", "");
        datee = SharedPrefs.getString("date", "");

        sum.setText(total);
        timee.setText(time);
        date.setText(datee);

        completeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Checkout.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(Checkout.this, "Order Placed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}