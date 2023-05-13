package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ExamPeriodsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        ListView listView = (ListView) findViewById(R.id.list_view);
      /*  ArrayList<String> examPeriods = new ArrayList<>();
        examPeriods.add(0,"Janar");
        examPeriods.add(1,"Prill");
        examPeriods.add(2,"Qershor");
        examPeriods.add(3,"Shtator");
        examPeriods.add(4,"Nentor");
*/
        String examPeriods[]={"Janar","Prill","Qershor","Shtator","Nentor"};

// instantiate the custom list adapter
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, examPeriods);

// get the ListView and attach the adapter
        ListView itemsListView = (ListView) findViewById(R.id.list_view);
        itemsListView.setAdapter(adapter);

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (examPeriods[position]=="Janar"){
                    Intent intent=new Intent(ExamPeriodsList.this,JanuaryPeriod.class);
                    startActivity(intent);

                } else if (examPeriods[position]=="Prill") {
                    Intent intent1=new Intent(ExamPeriodsList.this,AprilPeriod.class);
                    startActivity(intent1);

                }
                else if (examPeriods[position]=="Qershor") {
                    Intent intent2=new Intent(ExamPeriodsList.this,JunePeriod.class);
                    startActivity(intent2);}
                else if (examPeriods[position]=="Shtator") {
                    Intent intent3=new Intent(ExamPeriodsList.this,SeptemberPeriod.class);
                    startActivity(intent3);}

                else if (examPeriods[position]=="Nentor") {
                    Intent intent4=new Intent(ExamPeriodsList.this,NovemberPeriod.class);
                    startActivity(intent4);}
            }
        });
    }


}







