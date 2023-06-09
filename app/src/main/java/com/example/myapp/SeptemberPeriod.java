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

public class SeptemberPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_september_period);
        ArrayList<String> examsSeptember=new ArrayList<>();
        examsSeptember.add("Programimi i orientuar ne Objekte,  30.09");
        examsSeptember.add("Inxhinieri Softuerike,  21.09");
        examsSeptember.add("Dizajni dhe analiza e algoritmeve,  24.09");
        examsSeptember.add("Elektronike,  02.10");
        SeptemberAdapter adapter=new SeptemberAdapter(this,examsSeptember);
        ListView listView=(ListView)findViewById(R.id.listView_September);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    showCustomPopup();
            }
        });

    }
    private void showCustomPopup() {
        final Dialog dialog = new Dialog(SeptemberPeriod.this);
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