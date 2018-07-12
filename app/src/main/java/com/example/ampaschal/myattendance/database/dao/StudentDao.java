package com.example.ampaschal.myattendance.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ampaschal.myattendance.database.models.Student;

import java.util.List;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Dao
public interface StudentDao {
    @Insert()
    void insertStudents(Student...students);

    @Delete()
    void deletsStudent(Student student);

    @Update()
    void updateStudent(Student student);

    @Query("SELECT * FROM Students")
    List<Student> getAllStudents();

    @Query("SELECT * FROM Students WHERE regNo LIKE :regNo")
    Student getStudent(String regNo);
}
