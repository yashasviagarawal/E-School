package com.example.loginsignupmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProfileActivity extends AppCompatActivity {

    TextView fname,lname,email,contact,parentscontact,whatsapp;
    ImageView profileimage;
    Button updateprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        parentscontact = findViewById(R.id.parentcontact);
        whatsapp = findViewById(R.id.whatsappno);
        updateprofile = findViewById(R.id.updateProfile);
        profileimage = findViewById(R.id.ProfileImage);

        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                startActivityForResult(intent,0);

            }
        });

        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateProfileActivity.this,"Profile Updated Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateProfileActivity.this,ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}