package com.example.infostorage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

    }
    public void superMethod(View view)
    {
        EditText textName= findViewById(R.id.PersonName);
        TextView firstName= findViewById(R.id.firstName);
        TextView lastName = findViewById(R.id.lastName);
        TextView studentId= findViewById(R.id.StudentID);
        TextView noResult=findViewById(R.id.noResult);



        MySQLiteOpenHelper helper=new MySQLiteOpenHelper(this, "SQLite.db", null, 1);
        SQLiteDatabase writeableDatabase=helper.getWritableDatabase();
        Cursor cursor=writeableDatabase.rawQuery("select*from student",null);
        while (cursor.moveToNext()) {
            String fName = cursor.getString(cursor.getColumnIndex("firstName"));
            String lName = cursor.getString(cursor.getColumnIndex("lastName"));
            String SId = cursor.getString(cursor.getColumnIndex("id"));
            String fullname=fName+lName;
            if(SId.equals(studentId.toString())){
                firstName.setText(fName);
                lastName.setText(lName);
                studentId.setText(SId);
            }
            else{
                noResult.setText("NO RESULT");
            }
        }
    }

}
