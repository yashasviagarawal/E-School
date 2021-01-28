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

public class NotesActivity extends AppCompatActivity {

    CardView physics,biology,chemistry,maths,english,hindi,history,civics,geography,economics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        getSupportActionBar().setTitle("Notes");

        physics = findViewById(R.id.physics_btn);
        biology = findViewById(R.id.biology_btn);
        chemistry = findViewById(R.id.chemistry_btn);
        maths = findViewById(R.id.maths_btn);
        english = findViewById(R.id.english_btn);
        hindi = findViewById(R.id.hindi_btn);
        history = findViewById(R.id.history_btn);
        civics = findViewById(R.id.civics_btn);
        geography = findViewById(R.id.geography_btn);
        economics = findViewById(R.id.economics_btn);

        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this,PhysicsTeacherActivity.class);
                startActivity(intent);
                //Toast.makeText(LibraryActivity.this,"This will take u to Physics Content",Toast.LENGTH_SHORT).show();
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryBiologyActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to Biology Content",Toast.LENGTH_SHORT).show();
            }
        });
        chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this,ChemistryActivity.class);
                startActivity(intent);
                //Toast.makeText(LibraryActivity.this,"This will take u to Chemistry Content",Toast.LENGTH_SHORT).show();
            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this,MathsActivity.class);
                startActivity(intent);
                //Toast.makeText(LibraryActivity.this,"This will take u to Maths Content",Toast.LENGTH_SHORT).show();
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this,EnglishActivity.class);
                startActivity(intent);
                //Toast.makeText(LibraryActivity.this,"This will take u to English Content",Toast.LENGTH_SHORT).show();
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryHindiActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to Hindi Content",Toast.LENGTH_SHORT).show();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryHistoryActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to History Content",Toast.LENGTH_SHORT).show();
            }
        });
        civics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryCivicsActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to Civics Content",Toast.LENGTH_SHORT).show();
            }
        });
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryGeographyActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to Geography Content",Toast.LENGTH_SHORT).show();
            }
        });
        economics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(LibraryActivity.this,LibraryEconomicsActivity.class);
                //startActivity(intent);
                Toast.makeText(NotesActivity.this,"This will take u to Economics Content",Toast.LENGTH_SHORT).show();
            }
        });
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
            Toast.makeText(NotesActivity.this,"this will take u to chat box",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.profile)
        {
            Intent intent = new Intent(NotesActivity.this,ProfileActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notice)
        {
            Intent intent = new Intent(NotesActivity.this,NotesActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.library)
        {
            Intent intent = new Intent(NotesActivity.this,LibraryActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(NotesActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}