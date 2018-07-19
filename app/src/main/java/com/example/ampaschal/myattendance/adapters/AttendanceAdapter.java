package com.example.ampaschal.myattendance.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ampaschal.myattendance.R;
import com.example.ampaschal.myattendance.database.models.RetreivedStudent;


import java.util.List;

/**
 * Created by AmPaschal on 09/07/2018.
 */

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>{
    private List<RetreivedStudent> retreivedStudentList;
    private Context context;

    class AttendanceViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAttendance;
        private TextView tvRegNo;
        private TextView tvName;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAttendance = itemView.findViewById(R.id.tv_attendance);
            tvRegNo = itemView.findViewById(R.id.tv_reg_no);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    public AttendanceAdapter(Context context, List<RetreivedStudent> list){
        this.retreivedStudentList = list;
        this.context = context;
        //Log.d("Debug", list.toString());
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attendance_list_item, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
        RetreivedStudent attendance = retreivedStudentList.get(position);
        holder.tvAttendance.setText(String.valueOf(attendance.getPercentageAttendance()));
        holder.tvRegNo.setText(attendance.getRegNo());
        holder.tvName.setText(attendance.getName());


    }

    @Override
    public int getItemCount() {
        return retreivedStudentList.size();
    }


}
