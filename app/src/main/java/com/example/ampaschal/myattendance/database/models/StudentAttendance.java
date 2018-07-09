package com.example.ampaschal.myattendance.database.models;

/**
 * Created by AmPaschal on 09/07/2018.
 */

public class StudentAttendance {
    private int regNo;
    private String name;
    private int percentageAttendance;

    public StudentAttendance(int regNo, String name, int percentageAttendance) {
        this.regNo = regNo;
        this.name = name;
        this.percentageAttendance = percentageAttendance;
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

    public int getPercentageAttendance() {
        return percentageAttendance;
    }

    public void setPercentageAttendance(int percentageAttendance) {
        this.percentageAttendance = percentageAttendance;
    }
}
