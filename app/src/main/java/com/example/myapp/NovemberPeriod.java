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
      examsNovember.add("Programimi i Orientuar ne Objekte,  11.11");
      examsNovember.add("Programimi ne Web,  18.11");
      examsNovember.add("Matematike,  11.11");
      examsNovember.add("Inxhinieri Softuerike,  15.11");
      examsNovember.add("Sistemet e Shperndara,  25.11");
      examsNovember.add("Siguria ne Internet, 15.11");
      examsNovember.add("Gjurmimi i te dhenave,  18.11");
      examsNovember.add("Elektronike,  18.11");
      examsNovember.add("Interneti,  15.11");
       NovemberAdapter adapter=new NovemberAdapter(this,examsNovember);
       ListView listView=(ListView)findViewById(R.id.listView_November);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               System.out.println("Hello World");

           }
       });
    }
}