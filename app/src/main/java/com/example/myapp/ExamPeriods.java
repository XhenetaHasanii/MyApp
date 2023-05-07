package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ExamPeriods extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_periods);
        Button button=(Button)findViewById(R.id.subjects);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                goToSubjects(v);

            }});}
    public void goToSubjects(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View popupView = inflater.inflate(R.layout.activity_custom_pop_main, null);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(popupView);

        dialog.show();
        dialog.setTitle("Custom Pop-up");


}
   }


