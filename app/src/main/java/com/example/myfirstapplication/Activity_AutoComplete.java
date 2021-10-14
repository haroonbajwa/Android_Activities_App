package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class Activity_AutoComplete extends AppCompatActivity implements TextWatcher {

    TextView selection;
    AutoCompleteTextView edit;
    String[] items= { "this", "is", "a",
            "really", "really2", "really3",
            "really4", "really5", "silly", "list"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        selection= (TextView) findViewById(R.id.selection);
        edit= (AutoCompleteTextView) findViewById(R.id.edit);
        edit.addTextChangedListener(this);
        edit.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items));
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        // needed for interface, but not used
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        selection.setText(edit.getText());
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // needed for interface, but not used
    }
}