package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExamPeriodList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
       ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayList<String> examPeriods = new ArrayList<>();
        examPeriods.add("Janar");
        examPeriods.add("Prill");
        examPeriods.add("Qershor");
        examPeriods.add("Shtator");
        examPeriods.add("Nentor");


// instantiate the custom list adapter
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, examPeriods);

// get the ListView and attach the adapter
        ListView itemsListView = (ListView) findViewById(R.id.list_view);
        itemsListView.setAdapter(adapter);

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (examPeriods.contains("Janar")){
                    Intent intent=new Intent(ExamPeriodList.this,JanuaryPeriod.class);
                    startActivity(intent);

                }

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
    }
}







