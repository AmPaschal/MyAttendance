package com.example.ampaschal.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ampaschal.myattendance.adapters.CourseAdapter;
import com.example.ampaschal.myattendance.database.AppDatabase;
import com.example.ampaschal.myattendance.database.models.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements CourseAdapter.OnCourseItemClick{
    public final static String TAG_COURSE = "Course code";
    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private List<Course> courseList = new ArrayList<>();
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appDatabase = AppDatabase.getInsstance(this);
        recyclerView = findViewById(R.id.rv_courses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseList = appDatabase.courseDao().getallCourses();
        courseAdapter = new CourseAdapter(getMockCourses(), this);
        courseAdapter.setOnCourseItemClick(this);
        recyclerView.setAdapter(courseAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCourseClick(View view, int pos) {
        Toast.makeText(this, "Course clicked on "+pos + " with courseCode "
                +view.getTag().toString(), Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(MainActivity.this, AttendanceActivity.class);
        intent.putExtra(TAG_COURSE, view.getTag().toString());
        startActivity(intent);
    }

    private List<Course> getMockCourses(){
        Course course = new Course("COE 504", "Microwave Transmission");
        courseList.add(course);

        course = new Course("COE 506", "Network Planning and Management");
        courseList.add(course);

        course = new Course("COE 508", "Principles of Radar");
        courseList.add(course);

        course = new Course("COE 510", "Reliability Engineering");
        courseList.add(course);

        return courseList;


    }
}
