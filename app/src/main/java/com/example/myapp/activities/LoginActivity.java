package com.example.myapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Afati;
import com.example.myapp.entities.Student;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        Student student = new Student("test", "test", "test", 1991232, "test", 3, "xheneta.hasani@gmail.com", 044122111, "044567767", "testParent");
        db.studentDao().insertStudent(student);

        Afati afatiOne = new Afati("Janar");
        Afati afatiTwo = new Afati("Prill");
        Afati afatiThree = new Afati("Qershor");
        Afati afatiFour = new Afati("Shtator");
        Afati afatiFive = new Afati("Nentor");
        db.afatiDao().insertAfat(afatiOne);
        db.afatiDao().insertAfat(afatiTwo);
        db.afatiDao().insertAfat(afatiThree);
        db.afatiDao().insertAfat(afatiFour);
        db.afatiDao().insertAfat(afatiFive);

        EditText username = findViewById(R.id.login_email);
        EditText password = findViewById(R.id.login_password);
        Button login = (Button) findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_username = username.getText().toString();
                String txt_password = password.getText().toString();
                if (!TextUtils.isEmpty(txt_username) && !TextUtils.isEmpty(txt_password)) {
                    Student studentTwo = db.studentDao().getStudentByEmailAndPassword(txt_username, txt_password);
                    if (studentTwo != null) {
                        startActivity(new Intent(LoginActivity.this, MenuActivity.class).putExtra("email", txt_username));
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong email or password!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Fill out all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}