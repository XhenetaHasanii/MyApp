package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.adapters.ProvimeAdapter;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Provimi;
import java.util.List;

public class ProvimetActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "EXTRA_DATA";

    private String afati;

    private List <Provimi> provimet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);

        Intent intent = getIntent();
        afati = intent.getStringExtra("afati");

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        provimet = db.provimiDao().getAllProvimetOfSpecificAfati(afati);

        ProvimeAdapter adapter = new ProvimeAdapter(ProvimetActivity.this, provimet);
        ListView listView1 = (ListView) findViewById(R.id.exam_list);
        listView1.setAdapter(adapter);

        LayoutInflater myinflater = getLayoutInflater();
        ViewGroup myHeader = (ViewGroup)myinflater.inflate(R.layout.header_exams, listView1, false);
        listView1.addHeaderView(myHeader, null, false);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}