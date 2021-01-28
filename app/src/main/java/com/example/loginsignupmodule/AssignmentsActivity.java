package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AssignmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
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
            Toast.makeText(AssignmentsActivity.this,"this will take u to chat box",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.profile)
        {
            Intent intent = new Intent(AssignmentsActivity.this,ProfileActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notice)
        {
            Intent intent = new Intent(AssignmentsActivity.this,NotesActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.library)
        {
            Intent intent = new Intent(AssignmentsActivity.this,LibraryActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(AssignmentsActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}

