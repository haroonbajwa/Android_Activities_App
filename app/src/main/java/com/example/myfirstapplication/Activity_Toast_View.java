package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Toast_View extends AppCompatActivity {

    EditText xBox;
    EditText yBox;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_view);

        xBox = (EditText)findViewById(R.id.xBox);
        yBox = (EditText)findViewById(R.id.yBox);

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast myToast = Toast.makeText(
                            getApplicationContext(),
                            "Hello! \n Here is the Toast...!",
                            Toast.LENGTH_LONG);
                    myToast.setGravity(Gravity.CENTER,
                            Integer.valueOf(xBox.getText().toString()),
                            Integer.valueOf(yBox.getText().toString()) );
                    myToast.show();
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }// onClick
        }); // listener
    }
}