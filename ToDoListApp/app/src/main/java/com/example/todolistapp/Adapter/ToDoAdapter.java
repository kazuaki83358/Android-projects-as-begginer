package com.example.todolistapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapp.AddNewTask;
import com.example.todolistapp.Home_Page;
import com.example.todolistapp.Model.ToDoModel;
import com.example.todolistapp.R;
import com.example.todolistapp.Utils.DataBaseHandler;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoModel> todoList;
    private Home_Page activity;
    private DataBaseHandler db;

    public ToDoAdapter(DataBaseHandler db, Home_Page activity) {
        this.activity = activity;
        this.db = this.db;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        db.openDatabase();
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    db.updateStatus(item.getId(),1);
                }else {
                    db.updateStatus(item.getId(),0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    private boolean toBoolean(int n) {
        return n != 0;
    }

    public void setTaskList(List<ToDoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }
    public Context getContext(){
        return activity;
    }
    public void editItem(int position){
        ToDoModel item = todoList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id",item.getId());
        bundle.putString("task", item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(activity.getSupportFragmentManager(), AddNewTask.TAG);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task;

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}
