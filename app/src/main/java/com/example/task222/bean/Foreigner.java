package com.example.task222.bean;

import com.example.simpleorm.annotation.Column;
import com.example.simpleorm.annotation.Default;
import com.example.simpleorm.annotation.NotNull;
import com.example.simpleorm.annotation.Primary;
import com.example.simpleorm.annotation.Table;

@Table
public class Foreigner {

    @Primary
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Default(defaultString = "Female")
    private String sex;

    @NotNull
    private int age;

    @NotNull
    private String Nationality;

    private long salary;

    @Default(defaultBoolean = true)
    @Column(ColumnName = "xidu")
    private boolean isDrugAbused;

    public Foreigner(String name, String sex, int age, String Nationality, long salary, boolean isDrugAbused) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.isDrugAbused = isDrugAbused;
        this.Nationality = Nationality;
    }

    public Foreigner(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setDrugAbused(boolean drugAbused) {
        isDrugAbused = drugAbused;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return Nationality;
    }

    public long getSalary() {
        return salary;
    }

    public boolean isDrugAbused() {
        return isDrugAbused;
    }
}
