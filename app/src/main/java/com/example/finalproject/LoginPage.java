package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText email, password;
    Button creatone, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        creatone = findViewById(R.id.createone);
        DB = new DBHelper(this, null, null, 1);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid = email.getText().toString();
                String passid = password.getText().toString();
                if(TextUtils.isEmpty(emailid) || TextUtils.isEmpty(passid))
                    Toast.makeText(LoginPage.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkemailpassword = DB.checkemailpassword(emailid, passid);
                    if (checkemailpassword == true){
                        Toast.makeText(LoginPage.this, "Logged in", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else{
                        Toast.makeText(LoginPage.this, "Log in failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        creatone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, SignInPage.class);
                startActivity(intent);
            }
        });
    }
}