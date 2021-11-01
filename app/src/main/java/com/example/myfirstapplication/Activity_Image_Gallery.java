package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.TextView;

public class Activity_Image_Gallery extends AppCompatActivity {

    TextView mySelection;
    Gallery myGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);
        mySelection = (TextView) findViewById(R.id.mySelection);
        // Bind the gallery defined in the main.xml
        // Apply a new (customized) ImageAdapter to it.
        myGallery = (Gallery) findViewById(R.id.myGallery);
        myGallery.setAdapter(new ImageAdapter(this));
        myGallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                mySelection.setText(" selected option: " + arg2 );
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                mySelection.setText("Nothing selected");
            }
        });
    }
}