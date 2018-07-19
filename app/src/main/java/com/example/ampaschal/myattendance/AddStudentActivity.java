package com.example.ampaschal.myattendance;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class AddStudentActivity extends AppCompatActivity {

    private TextInputEditText etName, etRegNo, etEmail;
    private Spinner spinner;
    private Button btAddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etName = findViewById(R.id.etName);
        etRegNo = findViewById(R.id.etRegNo);
        etEmail = findViewById(R.id.etEmail);

        btAddStudent = findViewById(R.id.btAddStudent);
        spinner = findViewById(R.id.spinner);

        btAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String name =
            }
        });
    }
}
