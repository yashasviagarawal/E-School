package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class StudentDashboard extends AppCompatActivity {

    CardView classwork,notes,TimeTable,Events,classes,assignment,exams,activities,homework,attendence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        getSupportActionBar().setTitle("Dashboard");

        classwork = findViewById(R.id.classWork);
        notes = findViewById(R.id.notes);
        TimeTable = findViewById(R.id.timetable);
        Events = findViewById(R.id.events);
        classes = findViewById(R.id.liveclass);
        assignment = findViewById(R.id.asignments);
        exams = findViewById(R.id.exams);
        activities = findViewById(R.id.activities);
        homework = findViewById(R.id.homeWork);
        attendence = findViewById(R.id.attendance);


        classwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ClassWorkActivity.class);
                startActivity(intent);


            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });
        TimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LiveClassActivity.class);
                startActivity(intent);


            }
        });
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AssignmentsActivity.class);
                startActivity(intent);


            }
        });
        exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });
        homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeWorkActivity.class);
                startActivity(intent);


            }
        });
        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id == R.id.chat_box_button )
        {
            Toast.makeText(StudentDashboard.this,"this will take u to chat box",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.profile)
        {
            Intent intent = new Intent(StudentDashboard.this,ProfileActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notice)
        {
            Intent intent = new Intent(StudentDashboard.this,NotesActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.library)
        {
            Intent intent = new Intent(StudentDashboard.this,LibraryActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(StudentDashboard.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}