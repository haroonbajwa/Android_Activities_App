package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class Activity_GridView extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView selection;
    String[] items= { "this", "is", "a", "really", "really2", "really3","really4", "really5", "silly", "list"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        selection = (TextView) findViewById(R.id.selection);
        GridView gv = (GridView) findViewById(R.id.grid);
        ArrayAdapter<String> aa= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items);
        gv.setAdapter(aa);
        gv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
        selection.setText(items[position]);
    }
}