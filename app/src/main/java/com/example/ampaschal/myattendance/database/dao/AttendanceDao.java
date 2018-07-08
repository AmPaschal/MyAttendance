package com.example.ampaschal.myattendance.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.example.ampaschal.myattendance.database.DateConverter;
import com.example.ampaschal.myattendance.database.models.Attendance;
import com.example.ampaschal.myattendance.database.models.Course;

import java.util.Date;
import java.util.List;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface AttendanceDao {
    @Insert()
    void insertAttendance(Attendance attendance);

    @Delete()
    void deleteAttendance(Attendance attendance);

    @Update()
    void updateAttendance(Attendance attendance);

    @Query("SELECT * FROM Attendance")
    List<Attendance> getAllAttendance();

    @Query("SELECT * FROM Attendance WHERE courseCode LIKE :courseCode")
    List<Attendance> getAttendanceForCourse(String courseCode);

    @Query("SELECT * FROM Attendance WHERE courseCode LIKE :courseCode AND timestamp = :date")
    List<Attendance> getAttendanceForCourseAndDate(String courseCode, Date date);

    @Query("SELECT * FROM Attendance WHERE regNo = :regNo")
    List<Attendance> getAttendanceForStudent(int regNo);

}
