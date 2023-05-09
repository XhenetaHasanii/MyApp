package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ExamPeriodList extends AppCompatActivity {

    Animation animation1;
    String afatiIProvimeve[]={"Janar","Prill","Qershor","Shtator"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        ListView listView=(ListView)findViewById(R.id.list_view);
        animation1= AnimationUtils.loadAnimation(this,R.anim.animation1);
        CustomBaseAdapter customBaseAdapter=new CustomBaseAdapter(ExamPeriodList.this,afatiIProvimeve);

        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ExamPeriodList.this,""+afatiIProvimeve[i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}







