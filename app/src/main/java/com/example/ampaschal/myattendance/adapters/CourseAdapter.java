package com.example.ampaschal.myattendance.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ampaschal.myattendance.R;
import com.example.ampaschal.myattendance.database.models.StudentAttendance;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by AmPaschal on 09/07/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    private ArrayList<StudentAttendance> studentList;

    private CourseAdapter(ArrayList list){
        this.studentList = list;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendance_list_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.tvAttendance.setText(studentList.get(position).getPercentageAttendance());
        holder.tvRegNo.setText(studentList.get(position).getRegNo());
        holder.tvName.setText(studentList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAttendance, tvRegNo, tvName;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAttendance = itemView.findViewById(R.id.tv_attendance);
            tvRegNo = itemView.findViewById(R.id.tv_reg_no);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
