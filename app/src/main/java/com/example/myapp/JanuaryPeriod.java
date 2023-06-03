package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

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



