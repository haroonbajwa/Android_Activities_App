package com.example.myfirstapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Sqlite extends AppCompatActivity {

    EditText studentRollNo, studentName, studentDept, studentContact, studentAddress;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        studentRollNo = findViewById(R.id.studentRollNo);
        studentName = findViewById(R.id.studentName);
        studentDept = findViewById(R.id.studentDept);
        studentContact = findViewById(R.id.studentContact);
        studentAddress = findViewById(R.id.studentAddress);

        insert = findViewById(R.id.btn_saveStud);
        update = findViewById(R.id.btn_updateStud);
        delete = findViewById(R.id.btn_deleteStud);
        view = findViewById(R.id.btn_viewStud);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int txt_rollNO = Integer.parseInt(studentRollNo.getText().toString());
                String txt_name = studentName.getText().toString();
                String txt_dept = studentDept.getText().toString();
                int txt_contact = Integer.parseInt(studentContact.getText().toString());
                String txt_address = studentAddress.getText().toString();

                Boolean checkInsertData = DB.insertStudentData(txt_rollNO, txt_name, txt_dept, txt_contact, txt_address);
                if(checkInsertData == true){
                    Toast.makeText(Activity_Sqlite.this, "New Student Record Inserted Successfully!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(Activity_Sqlite.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int txt_rollNO = Integer.parseInt(studentRollNo.getText().toString());
                String txt_name = studentName.getText().toString();
                String txt_dept = studentDept.getText().toString();
                int txt_contact = Integer.parseInt(studentContact.getText().toString());
                String txt_address = studentAddress.getText().toString();

                Boolean checkUpdateData = DB.updateStudentData(txt_rollNO, txt_name, txt_dept, txt_contact, txt_address);
                if(checkUpdateData == true){
                    Toast.makeText(Activity_Sqlite.this, "Student Record Updated Successfully!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(Activity_Sqlite.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int txt_rollNO = Integer.parseInt(studentRollNo.getText().toString());

                Boolean checkDeleteData = DB.deleteStudentData(txt_rollNO);
                if(checkDeleteData == true){
                    Toast.makeText(Activity_Sqlite.this, "Student Record Deleted Successfully!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(Activity_Sqlite.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = DB.viewStudentData();
                if(result .getCount() == 0){
                    Toast.makeText(Activity_Sqlite.this, "No Record Exists!", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Roll No: " + result.getString(0) + "\n");
                    buffer.append("Name: " + result.getString(1) + "\n");
                    buffer.append("Department: " + result.getString(2) + "\n");
                    buffer.append("Contact: " + result.getString(3) + "\n");
                    buffer.append("Address: " + result.getString(4) + "\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Sqlite.this);
                builder.setCancelable(true);
                builder.setTitle("Students Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}