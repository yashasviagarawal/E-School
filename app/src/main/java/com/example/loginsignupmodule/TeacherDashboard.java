package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TeacherDashboard extends AppCompatActivity {

    private Toolbar toolbar;
    TextView name;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    String uid;
    String schoolname = " ";

    CardView classwork,notes,TimeTable,Events,classes,assignment,exams,activities,homework,attendence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

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
                finish();
            }
        });




/*        name = findViewById(R.id.teachers_name);
        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        uid = fauth.getCurrentUser().getUid();

        DocumentReference documentReference = fstore.collection(" "+ schoolname + "User/").document(uid);
        documentReference.addSnapshotListener(TeacherDashboard.this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                name.setText(documentSnapshot.getString("Fullname"));
            }
        });*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id == R.id.chat_box_button )
        {
            Toast.makeText(TeacherDashboard.this,"this will take u to chat box",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.profile)
        {
            Intent intent = new Intent(TeacherDashboard.this,ProfileActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notice)
        {
            Intent intent = new Intent(TeacherDashboard.this,NotesActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.library)
        {
            Intent intent = new Intent(TeacherDashboard.this,LibraryActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(TeacherDashboard.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}