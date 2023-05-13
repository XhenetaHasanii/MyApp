package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kotlin.collections.UArraySortingKt;

public class NovemberPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_november_period);
      ArrayList<String> examsNovember=new ArrayList<>();
      examsNovember.add("Programimi i Orientuar ne Objekte");
      examsNovember.add("Programimi ne Web");
      examsNovember.add("Matematike");
      examsNovember.add("Inxhinieri Softuerike");
      examsNovember.add("Sistemet e Shperndara");
      examsNovember.add("Siguria ne Internet");
      examsNovember.add("Gjurmimi i te dhenave");
      examsNovember.add("Elektronike");
      examsNovember.add("Interneti");
       NovemberAdapter adapter=new NovemberAdapter(this,examsNovember);
       ListView listView=(ListView)findViewById(R.id.listView_November);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           }
       });
    }
}