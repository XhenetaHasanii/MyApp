package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExamPeriodList extends AppCompatActivity {
    ListView listView;
    String month [] ={"Janar","Prill","Qershor","Shtator"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        listView=(ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,month);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*String select= (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, ""+select, Toast.LENGTH_SHORT).show();*/
                /*Intent intent=new Intent(MainActivity.this,ListSubjects.class);*/
                /*intent.putExtra("itemPosition",position);*/
                /* startActivity(intent);*/

            }
        });
    }
    private void showCustomPopup() {
        final Dialog dialog = new Dialog(ExamPeriodList.this);
        dialog.setContentView(R.layout.custom_popup);
        dialog.setCancelable(true);

        TextView textViewMessage = dialog.findViewById(R.id.textViewMessage);
        Button buttonClose = dialog.findViewById(R.id.buttonClose);

        textViewMessage.setText("This is a custom popup with text!");

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }}







