package com.example.ampaschal.myattendance.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by AmPaschal on 09/07/2018.
 */
@Entity
public class StudentAttendance {
    @PrimaryKey @NonNull
    private String regNo;
    private int noClassesAttended;

    public StudentAttendance() {
    }

    public StudentAttendance(String regNo, String name, int noClassesAttended) {
        this.regNo = regNo;
        this.noClassesAttended = noClassesAttended;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getNoClassesAttended() {
        return noClassesAttended;
    }

    public void setNoClassesAttended(int noClassesAttended) {
        this.noClassesAttended = noClassesAttended;
    }

}
