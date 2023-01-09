package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Itempage extends AppCompatActivity {
    BottomNavigationView navigator;
    TextView plus,minus,txt;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itempage);
        getSupportActionBar().hide();

        navigator=findViewById(R.id.bottomNavigationView);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        txt=findViewById(R.id.txt);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                txt.setText(String.valueOf(i));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i<2){
                    Toast.makeText(Itempage.this,"Choose valid number",Toast.LENGTH_SHORT).show();
                }else{
                    i--;
                    txt.setText(String.valueOf(i));
                }
            }
        });


        navigator.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent=new Intent(Itempage.this,HomePage.class);
                        startActivity(intent);
                        finish();

                    case R.id.profile:
                        Intent intent1=new Intent(Itempage.this,Profile.class);
                        startActivity(intent1);
                        finish();

                    case R.id.chat:
                        Intent intent4=new Intent(Itempage.this,Chat.class);
                        startActivity(intent4);
                        finish();

                    case R.id.cart:
                        Intent intent3=new Intent(Itempage.this,Cart.class);
                        startActivity(intent3);
                        finish();
                }
                return true;
            }
        });


    }
}