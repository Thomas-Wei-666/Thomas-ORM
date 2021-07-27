package com.example.simpleorm.model;

public class MyColumn {
    private String ColumnName;
    private boolean isPrimary;
    private boolean isAutoIncrement;
    private String TYPE;

    private boolean Notnull;

    public boolean isNotnull() {
        return Notnull;
    }

    public void setNotnull(boolean notnull) {
        Notnull = notnull;
    }

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

    public void setAutoIncrement(boolean autoIncrement) {
        this.isAutoIncrement = autoIncrement;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }
}
