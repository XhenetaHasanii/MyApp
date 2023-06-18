package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Student;

public class ProfiliActivity extends AppCompatActivity {

    private String userEmail;

    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setElevation(0);

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("userEmail");

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());


        student = db.studentDao().getStudentByEmail(userEmail);


        TextView emri = findViewById(R.id.emri);
        TextView mbiemri = findViewById(R.id.mbiemri);
        TextView imella = findViewById(R.id.email);
        TextView viti = findViewById(R.id.vitiStudimeve);
        TextView datelindja = findViewById(R.id.datelindja);
        TextView telNumri = findViewById(R.id.tel);
        TextView adresa = findViewById(R.id.adresa);
        TextView numriPersonal = findViewById(R.id.nrPersonal);
        Button backButton = (Button) findViewById(R.id.back_to_menu_from_profile);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String firstName = "";
        String lastName = "";
        Integer yearLevel = 0;
        String address = "";
        String birthDate = "";
        Integer phoneNumber = 0;
        Integer personalNumber = 0;

        firstName = student.getFirstName();
        lastName = student.getLastName();
        yearLevel = student.getYearLevel();
        address = student.getAddress();
        birthDate = student.getBirthDate();
        phoneNumber = student.getPhoneNumber();
        personalNumber = student.getPersonalNumber();

        emri.setText(firstName);
        mbiemri.setText(lastName);
        viti.setText(Integer.toString(yearLevel));
        imella.setText(userEmail);
        datelindja.setText(birthDate);
        telNumri.setText(Integer.toString(phoneNumber));
        adresa.setText(address);
        numriPersonal.setText(Integer.toString(personalNumber));

    }
}

