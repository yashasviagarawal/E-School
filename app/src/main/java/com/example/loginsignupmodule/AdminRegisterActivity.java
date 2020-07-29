package com.example.loginsignupmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.ktx.Firebase;

public class AdminRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toast.makeText(this,"Welcome to Registration Page",Toast.LENGTH_SHORT).show();

        Button register;
        final EditText Username,Email,Password,ConfPass,schoolcode;
        TextView gotologin;
        final String emptyString = "";

        register = findViewById(R.id.register_Button);
        Email = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.inputPassword);
        gotologin = findViewById(R.id.gotologin);
        Username = findViewById(R.id.inputUsername);
        ConfPass = findViewById(R.id.inputConfirmPassword);
        schoolcode = findViewById(R.id.inputSchoolCode);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Username.getText().toString().equals("") || Email.getText().toString().equals("") ||  Password.getText().toString().equals("") || ConfPass.getText().toString().equals("") || schoolcode.getText().toString().equals("")) {
                    Toast.makeText(AdminRegisterActivity.this,"All Fields are Mandatory !!!",Toast.LENGTH_SHORT).show();

                    Username.setText("");
                    Email.setText("");
                    Password.setText("");
                    ConfPass.setText("");
                    schoolcode.setText("");
                } else if ( Password.getText().toString().equals(ConfPass.getText().toString())) {


                }
                else
                {
                    Toast.makeText(AdminRegisterActivity.this,"Password did not Matched",Toast.LENGTH_SHORT).show();
                    Username.setText("");
                    Email.setText("");
                    Password.setText("");
                    ConfPass.setText("");
                    schoolcode.setText("");
                }
            }
        });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminRegisterActivity.this, AdminLoginActivity.class);
                startActivity(intent);

            }
        });

    }
}