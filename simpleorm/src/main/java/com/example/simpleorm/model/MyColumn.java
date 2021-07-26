package com.example.simpleorm.model;

public class MyColumn {
    private String ColumnName;
    private boolean isPrimary;
    private boolean selfIncrease;
    private String TYPE;

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public void setSelfIncrease(boolean selfIncrease) {
        this.selfIncrease = selfIncrease;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public boolean isSelfIncrease() {
        return selfIncrease;
    }
}
