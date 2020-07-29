package com.example.loginsignupmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Button login;
        final EditText Email,Password,schoolcode;
        TextView forgotpassword;

        login = findViewById(R.id.login_Button);
        Email = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.inputPassword);
        forgotpassword = findViewById(R.id.forgotPassword);
        schoolcode = findViewById(R.id.inputSchoolCode);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Email.getText().toString().equals("") ||  Password.getText().toString().equals("")|| schoolcode.getText().toString().equals("")) {
                    Toast.makeText(StudentLoginActivity.this,"All Fields are Mandatory !!!",Toast.LENGTH_SHORT).show();


                    Email.setText("");
                    Password.setText("");
                    schoolcode.setText("");
                }
                else
                {
                    Toast.makeText(StudentLoginActivity.this,"Password did not Matched",Toast.LENGTH_SHORT).show();

                    Email.setText("");
                    Password.setText("");
                    schoolcode.setText("");
                }
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLoginActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}