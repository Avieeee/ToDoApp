package com.mobile.taskmanagement;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ToDo_List extends AppCompatActivity {

    TextView FirstTitleToDo;
    TextView SecondSentences;
    DatabaseReference DatabaseReference;
    RecyclerView our;
    ArrayList<MyTask> list;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do__list);

        FirstTitleToDo = (TextView) findViewById(R.id.FirstTitlePage);
        SecondSentences = (TextView) findViewById(R.id.SecondSentences);

        // This is working for the data
        our = findViewById(R.id.our);
        our.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyTask>();

        // get data from FireBase Database by google
        DatabaseReference = FirebaseDatabase.getInstance().getReference().child("TaskApp");
        DatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This is set code for retrieve data and replace the layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MyTask p = dataSnapshot1.getValue(MyTask.class);
                    list.add(p);
                }
                taskAdapter = new TaskAdapter(ToDo_List.this, list);
                our.setAdapter(taskAdapter);
                taskAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // This is set code for showing an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
