package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        Button login;
        final EditText Email,Password,schoolcode;
        TextView forgotpassword;

        String schoolname = " ";

        final FirebaseAuth firebaseAuth;
        FirebaseDatabase database;
        FirebaseUser currentuser;

        forgotpassword = findViewById(R.id.forgotPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        currentuser = firebaseAuth.getCurrentUser();

        login = findViewById(R.id.login_Button);
        Email = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.inputPassword);
        forgotpassword = findViewById(R.id.forgotPassword);
        schoolcode = findViewById(R.id.inputSchoolCode);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Email.getText().toString().equals("") ||  Password.getText().toString().equals("")|| schoolcode.getText().toString().equals("")) {
                    Toast.makeText(TeacherLoginActivity.this,"All Fields are Mandatory !!!",Toast.LENGTH_SHORT).show();


                    Email.setText("");
                    Password.setText("");
                    schoolcode.setText("");
                }
                else {

                    Intent intent = new Intent(TeacherLoginActivity.this,TeacherDashboard.class);
                    startActivity(intent);

                    Toast.makeText(TeacherLoginActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    /*firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(TeacherLoginActivity.this, TeacherDashboard.class);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(TeacherLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        Toast.makeText(TeacherLoginActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                                        Email.setText("");
                                        Password.setText("");
                                        schoolcode.setText("");
                                    }
                                }
                            });*/

                }
            }
        });

    }


}