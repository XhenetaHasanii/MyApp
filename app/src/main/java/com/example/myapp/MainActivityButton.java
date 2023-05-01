package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityButton extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_button);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCalendar();
            }
        });
    }
    public void goToProfile(){
        Intent intent=new Intent(this,OnlyTest.class);
        startActivity(intent);
}
public void goToCalendar(){
    Intent intent=new Intent(this,MainActivity.class);
    startActivity(intent);}
}