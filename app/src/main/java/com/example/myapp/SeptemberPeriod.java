package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SeptemberPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_september_period);
        ArrayList<String> examsSeptember=new ArrayList<>();
        examsSeptember.add("Java");
        examsSeptember.add("Inxhinieri Softuerike");
        SeptemberAdapter adapter=new SeptemberAdapter(this,examsSeptember);
        ListView listView=(ListView)findViewById(R.id.listView_September);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}