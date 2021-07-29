package com.example.simpleorm.model;

import android.util.Log;

import com.example.simpleorm.interfaces.ComplexCondition;

public class or implements ComplexCondition {
    private StringBuilder builder = new StringBuilder();

    public or(String ... items){
        for (int i = 0; i < items.length; i++) {
            builder.append(items[i]);
            if (i != items.length - 1) {
                builder.append(" or");
            }
        }
    }
    @Override
    public String decodeCondition() {
        Log.i("or", builder.toString());
        return builder.toString();
    }
}
