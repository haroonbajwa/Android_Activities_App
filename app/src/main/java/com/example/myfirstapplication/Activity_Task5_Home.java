package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Task5_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5_home);
    }

    public void simpleListOnClick(View view) {
        Intent intent = new Intent(this, Activity_Simple_List.class);
        startActivity(intent);
    }

    public void spinnerListOnClick(View view) {
        Intent intent = new Intent(this, Activity_Spinner_List.class);
        startActivity(intent);
    }

    public void gridViewOnClick(View view) {
        Intent intent = new Intent(this, Activity_GridView.class);
        startActivity(intent);
    }

    public void autoCompleteOnClick(View view) {
        Intent intent = new Intent(this, Activity_AutoComplete.class);
        startActivity(intent);
    }

    public void imageGalleryOnClick(View view) {
    }
}