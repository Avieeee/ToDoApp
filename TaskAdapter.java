package com.mobile.taskmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TheViewHolder> {

    Context context;
    ArrayList<MyTask> myTask;

    public TaskAdapter(Context c, ArrayList<MyTask> p) {
        context = c;
        myTask = p;
    }


    class TheViewHolder extends RecyclerView.ViewHolder {

        TextView TitleTodo;
        TextView Desciption;
        TextView Deadline;

        public TheViewHolder(@NonNull View itemView) {
            super(itemView);
            TitleTodo = (TextView) itemView.findViewById(R.id.title_todo);
            Desciption = (TextView) itemView.findViewById(R.id.whatdo);
            Deadline = (TextView) itemView.findViewById(R.id.deadline);
        }
    }

    @NonNull
    @Override
    public TheViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TheViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_lists_todo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolder viewHolder, int i) {
       /* viewHolder.TitleTodo.setText(lists_todo.get(i).getTaskTitle());
        viewHolder.Desciption.setText(lists_todo.get(i).getDescription());
        viewHolder.Deadline.setText(lists_todo.get(i).getDeadlines());*/

    }

    @Override
    public int getItemCount() {
        return myTask.size();
    }
}
