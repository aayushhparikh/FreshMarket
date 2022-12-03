package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {

    EditText email, password, repassword;
    Button signUpButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        repassword = findViewById(R.id.password3);

        signUpButton = findViewById(R.id.signin2);

        DB = new DBHelper(this, null, null, 1);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailid = email.getText().toString();
                String passid = password.getText().toString();
                String repassid = repassword.getText().toString();

                if (TextUtils.isEmpty(emailid) || TextUtils.isEmpty(passid) || TextUtils.isEmpty(repassid))
                    Toast.makeText(SignInPage.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    if (passid.equals(repassid)) {
                        Boolean checkuser = DB.checkemail(emailid);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(emailid, passid);
                            if (insert == true){
                                Toast.makeText(SignInPage.this, "Registered!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(SignInPage.this, "Registered Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignInPage.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignInPage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}