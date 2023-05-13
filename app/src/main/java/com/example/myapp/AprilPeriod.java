package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AprilPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_april_period);
        ArrayList<String> examsApril = new ArrayList<>();
        examsApril.add("Java");
        examsApril.add("PHP");
        examsApril.add("KNK");
        AprilAdapter adapter = new AprilAdapter(this, examsApril);
        ListView listView = (ListView) findViewById(R.id.listView_April);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AprilPeriod.this, StudentProfile.class);
                startActivity(intent);
            }
        });

    }
}