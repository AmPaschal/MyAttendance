package com.example.ampaschal.myattendance.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ampaschal.myattendance.database.dao.AttendanceDao;
import com.example.ampaschal.myattendance.database.dao.CourseDao;
import com.example.ampaschal.myattendance.database.dao.StudentAttendanceDao;
import com.example.ampaschal.myattendance.database.dao.StudentDao;
import com.example.ampaschal.myattendance.database.models.Attendance;
import com.example.ampaschal.myattendance.database.models.Course;
import com.example.ampaschal.myattendance.database.models.Student;
import com.example.ampaschal.myattendance.database.models.StudentAttendance;

/**
 * Created by AmPaschal on 06/07/2018.
 */
@Database(entities = {Attendance.class, Course.class, Student.class, StudentAttendance.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract AttendanceDao attendanceDao();
    public abstract CourseDao courseDao();
    public abstract StudentDao studentDao();
    public abstract StudentAttendanceDao studentAttendanceDao();

    public static final String DATABASE_NAME = "attendanceDb";

    private static Object LOCK = new Object();
    private static volatile AppDatabase sInsstance;

    public static AppDatabase getInsstance(Context context){
        if (sInsstance == null) {
            synchronized (LOCK){
                if (sInsstance == null){
                    sInsstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return sInsstance;
    }
}
