package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

public class JanuaryPeriod extends AppCompatActivity {
    public static final String EXTRA_DATA = "EXTRA_DATA";
    Parcel in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_january_period);

        ArrayList<Provimi> periodExams = getIntent().getParcelableArrayListExtra("provimet");
        //ne qit list periodExams i ki provimet si objekte, mrena seciit objekt e ki emrin e provimit edhe daten, shfaqe ne nje list view per userin
    }
}