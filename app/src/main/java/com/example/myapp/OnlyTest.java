package com.example.myapp;

import static com.example.myapp.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnlyTest extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_only_test);
        Button button=(Button) findViewById(R.id.backToLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backToLogin();
            }
        });



    }
    public void backToLogin(){
        Intent intent=new Intent(this,MainActivityButton.class);
        startActivity(intent);
    }
}