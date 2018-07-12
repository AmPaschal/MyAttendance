package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Entity(tableName = "Students", indices = {@Index(value = {"regNo"}, unique = true)})
public class Student {
    @PrimaryKey @NonNull
    private String regNo;
    private String name;

    public Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
