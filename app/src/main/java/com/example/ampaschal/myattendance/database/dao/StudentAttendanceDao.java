package com.example.ampaschal.myattendance.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ampaschal.myattendance.database.models.StudentAttendance;

import java.util.List;

/**
 * Created by AmPaschal on 11/07/2018.
 */
@Dao
public interface StudentAttendanceDao {
    @Insert
    void insertStudentAttendance(StudentAttendance studentAttendance);

    @Delete
    void deleteStudentAttendance(StudentAttendance studentAttendance);

    @Update
    void updateStudentAttendance(StudentAttendance studentAttendance);

    @Query("SELECT * FROM StudentAttendance WHERE regNo LIKE :regNo")
    StudentAttendance getStudentAttendanceByCourseAndRegno(String regNo);

    @Query("SELECT * FROM StudentAttendance")
    List<StudentAttendance> getAllStudentAttendance();
}
