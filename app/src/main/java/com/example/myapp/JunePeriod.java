package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class JunePeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_june_period);
        ArrayList<String> examsJune=new ArrayList<>();
        examsJune.add("Java");
        examsJune.add("PHP");
        JuneAdapter adapter=new JuneAdapter(this,examsJune);
        ListView listView=(ListView)findViewById(R.id.listView_June);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Hello World");
            }
        });

    }
}