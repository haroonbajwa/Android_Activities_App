package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void task4OnClick(View view) {
        Intent intent = new Intent(this, Activity_Task4_Home.class);
        startActivity(intent);
    }

    public void task5OnClick(View view) {
        Intent intent = new Intent(this, Activity_Task5_Home.class);
        startActivity(intent);
    }

    public void task6OnClick(View view) {
        Intent intent = new Intent(this, Activity_Toast_View.class);
        startActivity(intent);
    }
}