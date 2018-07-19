package com.example.ampaschal.myattendance;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ampaschal.myattendance.adapters.AttendanceAdapter;
import com.example.ampaschal.myattendance.database.DatabaseHelper;
import com.example.ampaschal.myattendance.database.models.RetreivedStudent;
import com.example.ampaschal.myattendance.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    private static List<RetreivedStudent> studentList = new ArrayList<>();;
    private static AttendanceAdapter attendanceAdapter;
    private RecyclerView recyclerView;
    private TextView tvCourse;
    private static EditText etDate;
    private static CheckBox cbSort;
    private static DatabaseHelper databaseHelper;
    private static String course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        course = getIntent().getStringExtra(MainActivity.TAG_COURSE);
        tvCourse = findViewById(R.id.tv_course);
        tvCourse.setText(course);
        cbSort = findViewById(R.id.cbSort);
        databaseHelper = new DatabaseHelper(this);

        etDate = findViewById(R.id.etDate);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
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
    static boolean checked;
    public void onCheckBoxClicked(View view) {
        checked = ((CheckBox)view).isChecked();
        if (view.getId() == R.id.cbSort){
            if (checked){
                recyclerView.setVisibility(View.VISIBLE);
            } else {
                recyclerView.setVisibility(View.GONE);

            }
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            Date date = new Date(calendar.getTimeInMillis());
            List<RetreivedStudent> retreivedStudentList = databaseHelper.retreiveSortedAttendance(course, date);
            studentList = retreivedStudentList;
            attendanceAdapter.notifyDataSetChanged();

            month++;
            AttendanceActivity.etDate.setText(day +"/"+ month +"/"+ year);
            if (!checked){
                cbSort.setChecked(true);
            }

        }
    }
}
