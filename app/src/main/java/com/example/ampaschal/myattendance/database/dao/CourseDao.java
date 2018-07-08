package com.example.ampaschal.myattendance.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ampaschal.myattendance.database.models.Course;


import java.util.List;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Dao
public interface CourseDao {
   @Insert()
    void insertCourse(Course... courses);

   @Delete()
    void deleteCourse(Course course);

   @Update()
    void updateCourse(Course course);

   @Query("SELECT * FROM Course")
    List<Course> getallCourses();

   @Query("SELECT * FROM Course WHERE course_code LIKE :courseCode")
    Course getCourse(String courseCode);
}
