package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Entity
public class Course {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "course_code")
    private String courseCode;

    @ColumnInfo(name = "course_title")
    private String coursseTitle;

    @ColumnInfo(name = "no_units")
    private String noUnits;

    @ColumnInfo(name = "no_classes")
    private int noClasses;

    public Course(String courseCode, String coursseTitle) {
        this.courseCode = courseCode;
        this.coursseTitle = coursseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCoursseTitle() {
        return coursseTitle;
    }

    public void setCoursseTitle(String coursseTitle) {
        this.coursseTitle = coursseTitle;
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
}
