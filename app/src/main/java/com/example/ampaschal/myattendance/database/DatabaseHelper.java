package com.example.ampaschal.myattendance.database;

import android.content.Context;

import com.example.ampaschal.myattendance.database.models.Attendance;
import com.example.ampaschal.myattendance.database.models.Course;
import com.example.ampaschal.myattendance.database.models.RetreivedStudent;
import com.example.ampaschal.myattendance.database.models.StudentAttendance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AmPaschal on 11/07/2018.
 */

public class DatabaseHelper {
    private AppDatabase appDatabase;
    private Context context;

    public DatabaseHelper(Context context){
        this.context = context;
        appDatabase = AppDatabase.getInstance(context);

    }

    public void insertAttendance(Attendance... attendance){
        for (int i = 0; i < attendance.length; i++){

            appDatabase.attendanceDao().insertAttendance(attendance[i]);

            String regNo = attendance[i].getRegNo();
            StudentAttendance studentAttendance =
                    appDatabase.studentAttendanceDao().getStudentAttendanceByCourseAndRegno(regNo);
            if (studentAttendance == null){
                studentAttendance = new StudentAttendance();
                studentAttendance.setRegNo(regNo);
                studentAttendance.setNoClassesAttended(1);
                appDatabase.studentAttendanceDao().insertStudentAttendance(studentAttendance);
                return;
            }
            studentAttendance.setNoClassesAttended(studentAttendance.getNoClassesAttended() + 1);
            appDatabase.studentAttendanceDao().updateStudentAttendance(studentAttendance);
        }
        //Remember to edit this code for multiple courses
        Course course = appDatabase.courseDao().getCourse("");
        course.setNoClasses(course.getNoClasses() + 1);
        appDatabase.courseDao().updateCourse(course);
    }

    public List<RetreivedStudent> retrieveStudentAttendance(){

        List<StudentAttendance> studentAttendanceList =
                appDatabase.studentAttendanceDao().getAllStudentAttendance();
        List<RetreivedStudent> retreivedStudentList = new ArrayList<>();
        for (StudentAttendance studentAttendance: studentAttendanceList){
            RetreivedStudent retreivedStudent;
            String regNo = studentAttendance.getRegNo();
            String name = appDatabase.studentDao().getStudent(regNo).getName();
            int noClassesAttended = studentAttendance.getNoClassesAttended();
            int noClassesHeld = appDatabase.courseDao().getCourse("").getNoClasses();
            String perccentageAttendance = ((noClassesAttended/noClassesHeld) * 100) +"%";
            retreivedStudent = new RetreivedStudent(regNo, name, perccentageAttendance);
            retreivedStudentList.add(retreivedStudent);
        }

        return retreivedStudentList;
    }

    public List<RetreivedStudent> retreiveSortedAttendance(String course, Date date){
        List<RetreivedStudent> retreivedStudentList = new ArrayList<>();
        List<Attendance> attendanceList =
                appDatabase.attendanceDao().getAttendanceForCourseAndDate(course, date);

        for (Attendance attendance: attendanceList){
            String regNo = attendance.getRegNo();
            String name = appDatabase.studentDao().getStudent(regNo).getName();
            String percentageAttendance = "";

            RetreivedStudent retreivedStudent = new RetreivedStudent(regNo, name, percentageAttendance);
            retreivedStudentList.add(retreivedStudent);
        }
        return retreivedStudentList;

    }
}
