package com.example.simpleorm.model;

import android.database.sqlite.SQLiteDatabase;

import com.example.simpleorm.annotation.Column;
import com.example.simpleorm.annotation.Primary;
import com.example.simpleorm.annotation.Table;
import com.google.android.material.tabs.TabLayout;

public class DatabaseManager<T> {
    private T target;
    private SQLiteDatabase mDatabase;
    private MyColumn myColumn;
    private String TableName;

    public DatabaseManager(T target, SQLiteDatabase database) {
        this.target = target;
        mDatabase = database;
        init();
    }

    private void init() {
        if (target != null && mDatabase != null) {
            Class targetClass = target.getClass();

            Table table = (Table) targetClass.getDeclaredAnnotation(Table.class);
            if (table.name().equals("")){
                TableName = targetClass.getName();
            }else {
                TableName = table.name();
            }

            /**
            myColumn.setColumnName(column.ColumnName());
            Primary primary = (Primary)targetClass.getAnnotation(Primary.class);
            myColumn.setPrimary(primary.isPrimary());
            myColumn.setSelfIncrease(primary.selfIncrease());
             **/
        }else {
            //TODO:抛出异常
        }
    }


    private void createTable() {

    }
}
