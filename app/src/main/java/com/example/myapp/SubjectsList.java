package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SubjectsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_list);
        ListView listView=(ListView)findViewById(R.id.listSubjects);
        ArrayList<String> listSubjects=new ArrayList<>();
        listSubjects.add("Java");
        listSubjects.add("PHP");
        listSubjects.add("Database");
        listSubjects.add("Web");
        listSubjects.add("C++");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.activity_subjects_list,listSubjects);
        listView.setAdapter(adapter);
    }
}