package com.example.myapp;

import static com.example.myapp.R.id.loginBtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivityLogin extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        MaterialButton loginBtn = (MaterialButton) findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivityLogin.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivityLogin.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();
                }
            }});
    }}
