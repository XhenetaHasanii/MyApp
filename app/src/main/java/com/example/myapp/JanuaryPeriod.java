package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class JanuaryPeriod extends AppCompatActivity  {
    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);


        ArrayList<Provimi> periodExams = getIntent().getParcelableArrayListExtra("provimet");
        //ne qit list periodExams i ki provimet si objekte, mrena seciit objekt e ki emrin e provimit edhe daten, shfaqe ne nje list view per userin<Provimi> arr;
        Adapter adapter=new Adapter(JanuaryPeriod.this,periodExams);
        ListView listView1= (ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });








}

    }



