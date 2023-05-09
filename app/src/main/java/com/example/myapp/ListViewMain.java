package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewMain extends AppCompatActivity {
    ListView listView;
    Animation animation1;
    String afatiIProvimeve[]={"Janar","Prill","Qershor","Shtator"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        ListView listView=(ListView)findViewById(R.id.list_view);
        animation1= AnimationUtils.loadAnimation(this,R.anim.animation1);
        CustomBaseAdapter customBaseAdapter=new CustomBaseAdapter(ListViewMain.this,afatiIProvimeve);

        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),""+afatiIProvimeve[i],Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomPopup();
            }
        });}
        private void showCustomPopup() {
            final Dialog dialog = new Dialog(ListViewMain.this);
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
        }
    }







