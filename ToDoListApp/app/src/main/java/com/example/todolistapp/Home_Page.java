package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.todolistapp.Adapter.ToDoAdapter;
import com.example.todolistapp.Model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

public class Home_Page extends AppCompatActivity {
    private RecyclerView taskRecyclerView;
    private ToDoAdapter taskAdapter;

    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        taskRecyclerView = findViewById(R.id.taskRecyclerView);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(this);
        taskRecyclerView.setAdapter(taskAdapter);

        taskList = new ArrayList<>();

        ToDoModel task = new ToDoModel();
        task.setTask("It's time to workout");
        task.setStatus(0);
        task.setId(1);

        taskList.add(task);
        taskList.add(task);

        taskAdapter.setTaskList(taskList);
    }
}
