package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListViewMain extends AppCompatActivity {
    String afatiIProvimeve[]={"Janar","Prill","Qershor","Shtator"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView=(ListView)findViewById(R.id.CustomListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), afatiIProvimeve);
        listView.setAdapter(customBaseAdapter);
    }
}