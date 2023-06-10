package com.example.myapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.adapters.ProvimeAdapter;
import com.example.myapp.entities.Provimi;
import java.util.ArrayList;

public class ProvimetActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);

        ArrayList<Provimi> periodExams = getIntent().getParcelableArrayListExtra("provimet");
        ProvimeAdapter adapter = new ProvimeAdapter(ProvimetActivity.this, periodExams);
        ListView listView1 = (ListView) findViewById(R.id.list);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}