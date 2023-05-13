package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class JanuaryPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);

        ArrayList<String> exams=new ArrayList<>();
        exams.add("Java");
        exams.add("PHP");
        exams.add("Database");
        CustomeBaseAdapterAnother adapter1=new CustomeBaseAdapterAnother(this,exams);
        ListView listView1=(ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (exams.contains("Java")){
                    Intent intent=new Intent(JanuaryPeriod.this,StudentProfile.class);
                    startActivity(intent);
            }
        }

        });}}