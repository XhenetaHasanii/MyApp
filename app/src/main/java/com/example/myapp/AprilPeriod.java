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

public class AprilPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_april_period);
        ArrayList<String> examsApril = new ArrayList<>();
        examsApril.add("Java,  20.04");
        examsApril.add("PHP  01.05");
        examsApril.add("KNK  27.04");
        AprilAdapter adapter = new AprilAdapter(this, examsApril);
        ListView listView = (ListView) findViewById(R.id.listView_April);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showCustomPopup();
            }
        });

    }
    private void showCustomPopup() {
        final Dialog dialog = new Dialog(AprilPeriod.this);
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