package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Entity(tableName = "Students", indices = {@Index(value = {"regNo"}, unique = true)})
public class Student {
    @PrimaryKey
    int regNo;
    String name;

    public Student(int regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
