package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home_activity2 extends AppCompatActivity {
    BottomNavigationView navigator;
    LinearLayout piz,drinks,burger;
    LinearLayout pizza;
    static String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        getSupportActionBar().hide();

        navigator=findViewById(R.id.bottomNavigationView);
        pizza=findViewById(R.id.pizza);
        piz=findViewById(R.id.piz);
        drinks=findViewById(R.id.drinks);
        burger=findViewById(R.id.burger);

        navigator.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.profile:
                        Intent intent=new Intent(getApplicationContext(),Profile.class);
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




        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="pizza";
                Intent intent=new Intent(home_activity2.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });
        piz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(home_activity2.this,Itempage.class);
                startActivity(intent);
                finish();
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="drinks";
                Intent intent=new Intent(home_activity2.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="burger";
                Intent intent=new Intent(home_activity2.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}