package com.example.simpleorm.model;

import android.util.Log;

import com.example.simpleorm.exception.ORMException;
import com.example.simpleorm.interfaces.ComplexCondition;

public class and implements ComplexCondition {
    private StringBuilder builder = new StringBuilder();

    public and(String[] columns, Operator[] operators, String[] constraints) {
        if (columns.length == constraints.length && operators.length == constraints.length) {
            int i = 0;
            for (String c : columns){
                builder.append(c).append(" ").append(decodeOperator(operators[i])).append(" ").append(constraints[i]);
                if (i != columns.length - 1) {
                    builder.append(" and ");
                }
                i++;
            }
            builder.append(";");
        }else {
            try {
                throw new ORMException("missing conditions");
            } catch (ORMException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String decodeCondition() {
        Log.i("and", builder.toString());
        return builder.toString();
    }

    private String decodeOperator(Operator operator){
        if (operator==Operator.EQUAL){
            return "=";
        }else if (operator == Operator.LARGER_THAN){
            return ">";
        }else {
            return "<";
        }
    }
}
