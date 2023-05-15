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

public class JanuaryPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);

        ArrayList<String> exams = new ArrayList<>();
        exams.add("Programimi i orientuar ne objekte,  20.01");
        exams.add("PHP,  23.01");
        exams.add("Database,  30.01");
        exams.add("Internet,  19.01");
        exams.add("Matematike3,  01.02");
        exams.add("Inxhinieri Softuerike,  03.02");
        exams.add("Elektronike,  08.02");

        JanuaryAdapter adapter1 = new JanuaryAdapter(this, exams);
        ListView listView1 = (ListView) findViewById(R.id.list);
        listView1.setAdapter(adapter1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showCustomPopup();
            }
        });
    }

    private void showCustomPopup() {
        final Dialog dialog = new Dialog(JanuaryPeriod.this);
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