package com.example.ampaschal.myattendance.database.models;

/**
 * Created by AmPaschal on 11/07/2018.
 */

public class RetreivedStudent {
    private String regNo;
    private String name;
    private String percentageAttendance;

    public RetreivedStudent(){

    }

    public RetreivedStudent(String regNo, String name, String percentageAttendance) {
        this.regNo = regNo;
        this.name = name;
        this.percentageAttendance = percentageAttendance;
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

    public String getPercentageAttendance() {
        return percentageAttendance;
    }

    public void setPercentageAttendance(String percentageAttendance) {
        this.percentageAttendance = percentageAttendance;
    }
}
