package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    BottomNavigationView navigator;
    FirebaseAuth auth;
    CircleImageView dp;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        dp=findViewById(R.id.dp);

        storageReference= FirebaseStorage.getInstance().getReference().child("uplod/tumpadp.jpg");
        try {
            final File localFile=File.createTempFile("tumpa","jpg");
            storageReference.getFile(localFile)
                    .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            dp.setImageBitmap(bitmap);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Profile.this,"Error in Fetching",Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        navigator=findViewById(R.id.bottomNavigationView);

        navigator.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent=new Intent(getApplicationContext(), HomePage1.class);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.cart:
                        Intent intent1=new Intent(getApplicationContext(),Cart.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.chat:
                        Intent intent2=new Intent(getApplicationContext(),Chat.class);
                        startActivity(intent2);
                        finish();
                        break;
                }
                return true;
            }
        });

    }
}