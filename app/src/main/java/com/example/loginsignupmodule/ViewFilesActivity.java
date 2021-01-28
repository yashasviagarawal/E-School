package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewFilesActivity extends AppCompatActivity {

    ListView Pdflistview;
    DatabaseReference databaseReference;
    List<UploadFile> uploadFiles;

    PhysicsTeacherActivity title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_files);

        Pdflistview = findViewById(R.id.pdflistviewer);
        uploadFiles = new ArrayList<>();




        viewAllFiles();
    }

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference(""+title);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postSnapshot: snapshot.getChildren())
                {
                    UploadFile uploadfile = postSnapshot.getValue(com.example.loginsignupmodule.UploadFile.class);
                    uploadFiles.add(uploadfile);

                }

                String[] uploads = new String[uploadFiles.size()];

                for(int i=0;i<uploads.length;i++)
                {
                    uploads[i] = uploadFiles.get(i).getName();
                }

                ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}