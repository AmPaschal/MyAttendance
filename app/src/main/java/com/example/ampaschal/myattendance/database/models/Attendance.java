package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.ampaschal.myattendance.database.DateConverter;

import java.util.Date;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Entity
@TypeConverters(DateConverter.class)
public class Attendance {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String courseCode;
    private int regNo;
    private Date timestamp;

    public Attendance(String courseCode, int regNo, Date timestamp) {
        this.courseCode = courseCode;
        this.regNo = regNo;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
