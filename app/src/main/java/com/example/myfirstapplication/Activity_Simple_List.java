package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        public class Activity_Simple_List extends ListActivity {
        TextView selection;
        String[] items= { "this", "is", "a", "really",
        "really2", "really3","really4",
        "really5", "silly", "list"};

        // next time try an empty list such as:
        // String[] items = {};


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_simple_list);
            setListAdapter(new ArrayAdapter<String>(
                            this,
                    android.R.layout.simple_list_item_1,
                    items));
            selection=(TextView)findViewById(R.id.selection);
        }

        protected void onListItemClick(ListView l, View v,
                                     int position, long id) {
            super.onListItemClick(l, v, position, id);
            String text = " position:"+ position + " "+ items[position];
            selection.setText(text);
        }
}