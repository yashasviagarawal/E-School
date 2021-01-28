package com.example.loginsignupmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView teacher,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this,"Welcome to Our Application",Toast.LENGTH_SHORT).show();

        teacher = findViewById(R.id.teacherlogin);
        student = findViewById(R.id.studentlogin);


        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TeacherLoginActivity.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}