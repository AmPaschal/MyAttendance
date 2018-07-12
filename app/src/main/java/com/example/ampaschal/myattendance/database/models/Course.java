package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.ampaschal.myattendance.database.DateConverter;

import java.util.Date;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Entity
@TypeConverters(DateConverter.class)
public class Course {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "course_code")
    private String courseCode;

    @ColumnInfo(name = "course_title")
    private String courseTitle;

    @ColumnInfo(name = "no_units")
    private String noUnits;

    @ColumnInfo(name = "no_classes")
    private int noClasses;

    private Date lastClassHeld;

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getNoUnits() {
        return noUnits;
    }

    public void setNoUnits(String noUnits) {
        this.noUnits = noUnits;
    }

    public int getNoClasses() {
        return noClasses;
    }

    public void setNoClasses(int noClasses) {
        this.noClasses = noClasses;
    }

    public Date getLastClassHeld() {
        return lastClassHeld;
    }

    public void setLastClassHeld(Date lastClassHeld) {
        this.lastClassHeld = lastClassHeld;
    }
}
