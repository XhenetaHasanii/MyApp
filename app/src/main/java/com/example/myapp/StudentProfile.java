package com.example.myapp;

import static com.example.myapp.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.student_profile);
        Button button=(Button)findViewById(id.backToLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backToLogin();
            }
        });


    }

    public void backToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}