package com.example.task222.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ajts.androidmads.library.SQLiteToExcel;
import com.example.simpleorm.model.DatabaseManager;
import com.example.task222.R;
import com.example.task222.bean.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.insert_test);
        Button button2 = findViewById(R.id.query_test);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

        Student student = new Student();
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.task222/stu.db",null);
        DatabaseManager<Student> databaseManager = new DatabaseManager<>(Student.class,sqLiteDatabase);
        databaseManager.createTable();
        student.setName("hhh");
        student.setAge(18);
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setAge(19);
        student1.setName("QAQ");
        student2.setName("TAT");
        student2.setAge(16);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.insert(student);
                databaseManager.insert(student2);
                databaseManager.insert(student1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseManager.query("name").getCursor();
                int i = 0;
                while (cursor.moveToNext()){
                    Log.i("cursor", cursor.getString(0));
                }
            }
        });


    }
}