package com.tatitati.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//        Toolbar toolbar = findViewById(R.id.);
//        setSupportActionBar(toolbar);

        Button about = (Button) findViewById(R.id.btn_back_to_main);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FirstPageActivity.class));
            }
        });

        Button addUser = (Button) findViewById(R.id.btn_add_user);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserDataPageActivity.class));
            }
        });
        Button addService = (Button) findViewById(R.id.btn_add_service);
        Button addFigures = (Button) findViewById(R.id.btn_enter_figures);
        Button showHistory = (Button) findViewById(R.id.btn_history);
        Button setNotifications = (Button) findViewById(R.id.btn_notification);
    }

}
