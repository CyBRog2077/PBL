package com.example.infostorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.OptionalDataException;
import java.util.*;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MySQLiteOpenHelper helper=new MySQLiteOpenHelper(this, "SQLite.db", null, 1);
        SQLiteDatabase writeableDatabase=helper.getWritableDatabase();
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
    public void subInfo(View view)
    {
        EditText firstName= findViewById(R.id.firstName);
        EditText lastName= findViewById(R.id.lastName);
        EditText studentId= findViewById(R.id.studentId);

        MySQLiteOpenHelper helper=new MySQLiteOpenHelper(this, "SQLite.db", null, 1);
        SQLiteDatabase writeableDatabase=helper.getWritableDatabase();
        writeableDatabase.execSQL("insert into student(firstName,lastName,id) values(?,?,?)", new Object[]{firstName.toString(),lastName.toString(),studentId.toString()});
        //Cursor cursor=writeableDatabase.rawQuery("select*from student",null);
        //while (cursor.moveToNext()){
            //String fName=cursor.getString(cursor.getColumnIndex("firstName"));
          //  String lName=cursor.getString(cursor.getColumnIndex("lastName"));
           // String SId=cursor.getString(cursor.getColumnIndex("id"));
            //if(firstName.toString().equals(fName)&&lastName.toString().equals(lName)){
              //  writeableDatabase.execSQL("update student set id=studentId where firstName=fName");
            //}
            //else if(studentId.toString().equals(SId)){
            //    writeableDatabase.execSQL("update student set firstName=");
            //}
        //}

        //ArrayList<Student> StudentData=new ArrayList<Student>();
        //Student obj= new Student(firstName.toString(),lastName.toString(),studentId.toString());
        //StudentData.add(obj);
        //return StudentData;
    }




}