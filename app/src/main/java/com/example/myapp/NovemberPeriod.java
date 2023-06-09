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


public class NovemberPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_november_period);
      ArrayList<String> examsNovember=new ArrayList<>();
      examsNovember.add("Programimi i Orientuar ne Objekte,  11.11");
      examsNovember.add("Programimi ne Web,  18.11");
      examsNovember.add("Matematike,  11.11");
      examsNovember.add("Inxhinieri Softuerike,  15.11");
      examsNovember.add("Sistemet e Shperndara,  25.11");
      examsNovember.add("Siguria ne Internet, 15.11");
      examsNovember.add("Gjurmimi i te dhenave,  18.11");
      examsNovember.add("Elektronike,  18.11");
      examsNovember.add("Interneti,  15.11");
       NovemberAdapter adapter=new NovemberAdapter(this,examsNovember);
       ListView listView=(ListView)findViewById(R.id.listView_November);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               showCustomPopup();
           }
       });
    }
    private void showCustomPopup() {
        final Dialog dialog = new Dialog(NovemberPeriod.this);
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