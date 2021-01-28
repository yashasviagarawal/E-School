package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    TextView fname,lname,email,contact,parentscontact,whatsapp;
    ImageView profileimage;
    Button updateprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        parentscontact = findViewById(R.id.parentcontact);
        whatsapp = findViewById(R.id.whatsappno);
        updateprofile = findViewById(R.id.updateprofile);
        profileimage = findViewById(R.id.ProfileImage);

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,UpdateProfileActivity.class);
                startActivity(intent);
                finish();
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
            Toast.makeText(ProfileActivity.this,"this will take u to chat box",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.profile)
        {
            Intent intent = new Intent(ProfileActivity.this,ProfileActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.notice)
        {
            Toast.makeText(ProfileActivity.this,"this will take u to Notice Board",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.library)
        {
            Intent intent = new Intent(ProfileActivity.this,LibraryActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}