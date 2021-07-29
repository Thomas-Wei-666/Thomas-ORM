package com.example.simpleorm.model;

import android.util.Log;

import com.example.simpleorm.interfaces.ComplexCondition;

public class and implements ComplexCondition {
    private StringBuilder builder = new StringBuilder();

    public and(String ... items){
        for (int i = 0; i < items.length; i++) {
            builder.append(items[i]);
            if (i != items.length - 1) {
                builder.append(" and");
            }
        }
    }
    @Override
    public String decodeCondition() {
        Log.i("and", builder.toString());
        return builder.toString();
    }
}
