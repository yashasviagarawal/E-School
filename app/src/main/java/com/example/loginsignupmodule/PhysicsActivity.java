package com.example.loginsignupmodule;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class PhysicsActivity extends AppCompatActivity {

    ListView phyicsPdf;
    DatabaseReference databaseReference;
    List<UploadFile> uploadFiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        phyicsPdf = findViewById(R.id.physics_pdf);

        viewAllFiles();
    }

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Physics");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}