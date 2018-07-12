package com.example.ampaschal.myattendance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ampaschal.myattendance.adapters.AttendanceAdapter;
import com.example.ampaschal.myattendance.database.models.RetreivedStudent;
import com.example.ampaschal.myattendance.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    private List<RetreivedStudent> studentList = new ArrayList<>();;
    private AttendanceAdapter attendanceAdapter;
    private RecyclerView recyclerView;
    private TextView tvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String course = getIntent().getStringExtra(MainActivity.TAG_COURSE);
        tvCourse = findViewById(R.id.tv_course);
        tvCourse.setText("Course: " + course);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        attendanceAdapter = new AttendanceAdapter(this, populateList());
        recyclerView.setAdapter(attendanceAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_populate){
            populateList();
        }

        return super.onOptionsItemSelected(item);
    }

    public List<RetreivedStudent> populateList() {
        RetreivedStudent attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        attendance = new RetreivedStudent(
                "20131846143", "Amusuo Paschal", "78");
        studentList.add(attendance);

        return studentList;

    }
}
