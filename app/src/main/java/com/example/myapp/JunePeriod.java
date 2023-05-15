package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class JunePeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_june_period);
        ArrayList<String> examsJune=new ArrayList<>();
        examsJune.add("Java,  25.06");
        examsJune.add("PHP,  03.07");
        examsJune.add("Arkitektura e kompjuterit,  01.07");
        examsJune.add("Ndermarresi,  20.06");
        examsJune.add("Menaxhimi i projekteve,  04.07");
        JuneAdapter adapter=new JuneAdapter(this,examsJune);
        ListView listView=(ListView)findViewById(R.id.listView_June);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showCustomPopup();
            }
        });

    }
    private void showCustomPopup() {
        final Dialog dialog = new Dialog(JunePeriod.this);
        dialog.setContentView(R.layout.custom_popup);
        dialog.setCancelable(true);

        TextView textViewMessage = dialog.findViewById(R.id.textViewMessage);
        Button buttonClose = dialog.findViewById(R.id.buttonClose);

        textViewMessage.setText("Shume suksese ne provim!");

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}