package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class TestProfile extends AppCompatActivity {
    private Student student;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_profile);

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("userEmail");

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        student = db.studentDao().getStudentByEmail(userEmail);

        TextView idStudentit = findViewById(R.id.id);
        TextView perdoruesi = findViewById(R.id.perdoruesi);
        TextView emri = findViewById(R.id.emri);
        TextView mbiemri = findViewById(R.id.mbiemri);
        TextView emriprinderit = findViewById(R.id.emriPrinderit);
        TextView datelindja = findViewById(R.id.datelindja);
        TextView nrLeternjoftimit = findViewById(R.id.nrLeternjoftimit);
        TextView vendlindja = findViewById(R.id.vendlindja);
        Button backButton = findViewById(R.id.back_to_menu_from_profile);
        Button informatatPersonale = findViewById(R.id.informatatPersonale);
        Button kontaktet = findViewById(R.id.kontaktet);

        informatatPersonale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informatatPersonale(v);
            }
        });
        kontaktet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontaktet(v);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String firstName = "";
        String email = "";
        String lastName = "";
        String nameOfParent = "";
        String birthDate = "";
        int personalNumber = 0;
        String birthPlace = "";

        int studentId = 0;
            firstName = student.getFirstName();
            email = student.getEmail();
            lastName = student.getLastName();
            nameOfParent = student.getNameOfParent();
            birthDate = student.getBirthDate();
            personalNumber = student.getPersonalNumber();
            /* birthPlace=student.getBirthPlace();*/
            /* studentId=student.getStudentId();*/

        /*  idStudentit.setText(studentId);*/
        emri.setText(firstName);
        perdoruesi.setText(email);
        mbiemri.setText(lastName);
        emriprinderit.setText(nameOfParent);
        datelindja.setText(birthDate);
        /* nrLeternjoftimit.setText(personalNumber);*/
        vendlindja.setText(birthPlace);
        /* numriPersonal.setText(Integer.toString(personalNumber));*/

    }

    public void informatatPersonale(View view) {
        Intent intent = new Intent(TestProfile.this, TestProfile.class);
        startActivity(intent);
    }

    public void kontaktet(View view) {
        Intent intent = new Intent(TestProfile.this, ProfiliActivity.class);
        startActivity(intent);
    }


}