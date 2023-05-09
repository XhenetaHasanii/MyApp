package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class ExamPeriods extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_periods);

      Button  button = (Button) findViewById(R.id.subjects);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSubjects(v);

            }});}

       public void goToSubjects(View view){
        Intent intent=new Intent(this,StudentProfile.class);
        startActivity(intent);
        }



}






