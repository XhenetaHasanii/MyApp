package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=(Button) findViewById(R.id.button);


    }


    public void openActivity2(View view) {
        Intent intent=new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}
