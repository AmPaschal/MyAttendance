package com.example.ampaschal.myattendance.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ampaschal.myattendance.R;
import com.example.ampaschal.myattendance.database.models.Course;

import java.util.List;

/**
 * Created by AmPaschal on 11/07/2018.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    private List<Course> courseList;
    private OnCourseItemClick onCourseItemClick;
    private Context context;


    class CourseViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        private TextView tvCourseCode, tvCourseTitle, tvClassesHeld;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseCode = itemView.findViewById(R.id.tv_course_code);
            tvCourseTitle = itemView.findViewById(R.id.tv_course_title);
            tvClassesHeld = itemView.findViewById(R.id.tv_classes_held);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onCourseItemClick.onCourseClick(view, getAdapterPosition());
        }
    }

    public CourseAdapter(List<Course> courseList, Context context) {
        this.courseList = courseList;
        this.context = context;
        this.onCourseItemClick = (OnCourseItemClick)context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_item, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.tvCourseCode.setText(course.getCourseCode());
        holder.tvCourseTitle.setText(course.getCourseTitle());
        //holder.tvClassesHeld.setText("Number of classes held: " + course.getNoClasses());

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public interface OnCourseItemClick{
        void onCourseClick(View view, int pos);
    }

    public void setOnCourseItemClick(OnCourseItemClick onCourseItemClick){
        this.onCourseItemClick = onCourseItemClick;
    }


}
