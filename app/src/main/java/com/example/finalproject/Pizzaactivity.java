package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Pizzaactivity extends AppCompatActivity {

    BottomNavigationView navigator;
    LinearLayout piz;
    TextView firstitem,seconditem,thirditem,fourthitem,fifthitem,sixthitem;
    ImageView firstimg;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaactivity);
        getSupportActionBar().hide();

        storageReference= FirebaseStorage.getInstance().getReference().child("images");

        piz=findViewById(R.id.itapizza);
        firstitem=findViewById(R.id.firtsitem);
        seconditem=findViewById(R.id.seconditem);
        thirditem=findViewById(R.id.thirditem);
        fourthitem=findViewById(R.id.fourthitem);
        fifthitem=findViewById(R.id.fifthitem);
        sixthitem=findViewById(R.id.sixthitem);
        firstimg=findViewById(R.id.firstimg);


        navigator=findViewById(R.id.bottomNavigationView);

        navigator.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent=new Intent(getApplicationContext(),HomePage.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.profile:
                        Intent intent3=new Intent(getApplicationContext(),Profile.class);
                        startActivity(intent3);
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

        if (HomePage.value.equals("drinks"))
        {
            firstitem.setText("CocaCola");
            try {
                final File localFile=File.createTempFile("cocacola","jpg");
                storageReference.getFile(localFile)
                        .addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                                Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                firstimg.setImageBitmap(bitmap);
                                Toast.makeText(Pizzaactivity.this,"Image fetched",Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Pizzaactivity.this,"Error in Fetching",Toast.LENGTH_SHORT).show();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }


            seconditem.setText("Pepsi");
            thirditem.setText("7Up");
            fourthitem.setText("RC cola");
            fifthitem.setText("MoJo");
            sixthitem.setText("Clemon");
        } else if (HomePage.value.equals("pizza"))
        {
            firstitem.setText("Chicken Pizza");
            seconditem.setText("Italian Pizza");
            thirditem.setText("BBQ Beef Pizza");
            fourthitem.setText("Mixed Pizza");
            fifthitem.setText("Pepporoni Pizza");
            sixthitem.setText("Cheesy Pizza");
        }else if (HomePage.value.equals("burger"))
        {
            firstitem.setText("Chicken Burger");
            seconditem.setText("Regular Burger");
            thirditem.setText("BBQ Beef Burger");
            fourthitem.setText("Mixed Burger");
            fifthitem.setText("Dosa Burger");
            sixthitem.setText("Cheese Burger");
        }

        piz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Pizzaactivity.this,Itempage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}