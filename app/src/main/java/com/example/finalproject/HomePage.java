package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {
    BottomNavigationView navigator;
    TextView login,signup;
    LinearLayout piz,drinks,burger;
    LinearLayout pizza;
    static String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
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


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,RegistrationPage.class);
                startActivity(intent);
                finish();
            }
        });


        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="pizza";
                Intent intent=new Intent(HomePage.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });
        piz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,Itempage.class);
                startActivity(intent);
                finish();
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="drinks";
                Intent intent=new Intent(HomePage.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value="burger";
                Intent intent=new Intent(HomePage.this,Pizzaactivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}