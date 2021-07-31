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
import com.example.simpleorm.model.Operator;
import com.example.simpleorm.model.and;
import com.example.task222.R;
import com.example.task222.bean.Foreigner;
import com.example.task222.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.insert_test);
        Button button2 = findViewById(R.id.query_test);
        Button button3 = findViewById(R.id.delete_test);
        Button button4 = findViewById(R.id.update_test);
        Button button5 = findViewById(R.id.create_test);
        Button button6 = findViewById(R.id.delete_table_test);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.task222/foreigner.db", null);
        DatabaseManager<Foreigner> databaseManager = new DatabaseManager<>(Foreigner.class, sqLiteDatabase);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.createTable();
            }
        });

        Foreigner foreigner = new Foreigner("Amanda","Female",17,"Austria",200002,false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.insert(foreigner);

                databaseManager.insertList(formDataList());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Foreigner> resultList =  databaseManager.query("name","sex","Nationality").whereClause(new and(new String[]{"age","Nationality"},new Operator[]{Operator.EQUAL,Operator.EQUAL},new String[]{"18","'United States'"})).getQueryResultAsInstance();
                 for (Foreigner f : resultList){
                     Log.i("Query",f.getName());
                     Log.i("Query",f.getSex());
                     Log.i("Query",f.getNationality());
                 }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.deleteMode().whereClause(new and(new String[]{"age"},new Operator[]{Operator.EQUAL},new String[]{"35"})).delete();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Foreigner foreigner1 = new Foreigner("Thomas","Male",18,"United States",190000,false);
                databaseManager.setUpdateData(foreigner1).whereClause(new and(new String[]{"name"},new Operator[]{Operator.EQUAL},new String[]{"'Thomas'"})).update();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.drop();
            }
        });


    }

    private List<Foreigner> formDataList(){
        Foreigner foreigner1 = new Foreigner("Thomas","Male",18,"South Afica",10000,false);
        Foreigner foreigner2 = new Foreigner("Alice" , "Female",18,"United States",20000,false);
        Foreigner foreigner3 = new Foreigner("Norah" , "Female",21,"China",300000,false);
        Foreigner foreigner4 = new Foreigner("Yoma","Female",20,"Japan",1234456,false);
        Foreigner foreigner5 = new Foreigner("David","Male",35,"Brazil",5000,true);

        List<Foreigner> foreigners = new ArrayList<>();
        foreigners.add(foreigner1);
        foreigners.add(foreigner2);
        foreigners.add(foreigner3);
        foreigners.add(foreigner4);
        foreigners.add(foreigner5);


        return foreigners;
    }
}