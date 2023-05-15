package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        Button login = (Button) findViewById(R.id.loginBtn);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = username.getText().toString();
                String txt_password = password.getText().toString();
                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Login.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(Login.this, "Password too short", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login.this,Menu.class);
                    startActivity(intent);
                }

        };
    });



}
}
