package com.example.loginsignupmodule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.List;

public class PhysicsTeacherActivity extends AppCompatActivity {

    EditText pdf_title;
    Button upload_btn;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_teacher);

        pdf_title = findViewById(R.id.physics_title);
        upload_btn = findViewById(R.id.uploadpdf);


        title = pdf_title.getText().toString();


        viewAllFiles();
    }

    private void viewAllFiles() {
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference=FirebaseDatabase.getInstance().getReference("Physics");

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectPdfFile();
            }
        });
    }

    private void selectPdfFile() {

        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select File"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            uploadeFile(data.getData());
        }
    }

    private void uploadeFile(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        StorageReference reference = storageReference.child("Physics/"+title+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete());
                        Uri url = uri.getResult();
                        UploadFile uploadFile = new UploadFile(title,url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadFile);

                        Toast.makeText(getApplicationContext(),"File Uploaded",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded: " + (int)progress + "%");
            }
        });
    }
}