package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.adapters.ProvimeAdapter;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Provimi;

import java.util.Calendar;
import java.util.Date;
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
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date test = cal.getTime();
        Provimi provimiOne = new Provimi("daa",1,test);
        Provimi provimiTwo = new Provimi("mikro",1,test);
        Provimi provimiThree = new Provimi("algoritme",2,test);
        Provimi provimiFour = new Provimi("baza",2,test);
        Provimi provimiFive = new Provimi("qarqe",3,test);
        Provimi provimiSix = new Provimi("sinjale",3,test);
        Provimi provimiSeven = new Provimi("programim",4,test);
        Provimi provimiEight = new Provimi("ndermarresi",4,test);
        Provimi provimiNine = new Provimi("php",5,test);
        Provimi provimiTen = new Provimi("inxhinieri softuerike",5,test);
        db.provimiDao().insertProvimi(provimiOne);
        db.provimiDao().insertProvimi(provimiTwo);
        db.provimiDao().insertProvimi(provimiThree);
        db.provimiDao().insertProvimi(provimiFour);
        db.provimiDao().insertProvimi(provimiFive);
        db.provimiDao().insertProvimi(provimiSix);
        db.provimiDao().insertProvimi(provimiSeven);
        db.provimiDao().insertProvimi(provimiEight);
        db.provimiDao().insertProvimi(provimiNine);
        db.provimiDao().insertProvimi(provimiTen);


        provimet = db.provimiDao().getAllProvimetOfSpecificAfati(afati);

        ProvimeAdapter adapter = new ProvimeAdapter(ProvimetActivity.this, provimet);
        ListView listView1 = (ListView) findViewById(R.id.exam_list);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}