package com.example.myfirstapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "StudentsData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table StudentDetails(RollNo INT Primary Key, Name TEXT, Department TEXT, Contact INT, Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("Drop Table if exists StudentDetails");
    }

    public Boolean insertStudentData (int rollNo, String name, String department, int contact, String address) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("RollNo", rollNo);
        contentValues.put("Name", name);
        contentValues.put("Department", department);
        contentValues.put("Contact", contact);
        contentValues.put("Address", address);

        long result = DB.insert("StudentDetails", null, contentValues);

        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateStudentData (int rollNo, String name, String department, int contact, String address) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Name", name);
        contentValues.put("Department", department);
        contentValues.put("Contact", contact);
        contentValues.put("Address", address);

        Cursor cursor = DB.rawQuery("select * from StudentDetails where rollNo = ? ", new String[] {String.valueOf(rollNo)});

        if(cursor.getCount() > 0) {

            long result = DB.update("StudentDetails", contentValues, "RollNo=?", new String[]{String.valueOf(rollNo)});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return  false;
        }
    }

    public Boolean deleteStudentData (int rollNo) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from StudentDetails where rollNo = ? ", new String[] {String.valueOf(rollNo)});

        if(cursor.getCount() > 0) {

            long result = DB.delete("StudentDetails", "RollNo=?", new String[] {String.valueOf(rollNo)});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return  false;
        }
    }

    public Cursor viewStudentData () {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from StudentDetails",  null);

        return cursor;
    }
}
