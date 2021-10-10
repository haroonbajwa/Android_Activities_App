package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity_Spinner_List extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView selection;
    String[] items= { "this", "is", "a",
            "really", "really2", "really3",
            "really4", "really5", "silly", "list"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_list);

        selection= (TextView) findViewById(R.id.selection);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);// set a clickable right push-button comboBoxto show items
        ArrayAdapter<String> aa= new ArrayAdapter<String>(
        this, android.R.layout.simple_spinner_item, items);// provide a particular design for the drop-down lines
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);// associate GUI spinner and adapter
        spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        selection.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        selection.setText("");
    }
}