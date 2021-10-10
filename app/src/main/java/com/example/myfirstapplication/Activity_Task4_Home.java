package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Task4_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_home);
    }

    public void activity1OnClick(View view) {
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }

    public void activity2OnClick(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void activity3OnClick(View view) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void activity4OnClick(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void activity5OnClick(View view) {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }
}