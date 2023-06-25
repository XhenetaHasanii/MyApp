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
import com.example.myapp.dto.EventDTO;
import com.example.myapp.entities.Afati;
import com.example.myapp.entities.Menza;
import com.example.myapp.entities.Provimi;
import com.example.myapp.entities.Student;
import java.util.Calendar;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        createDummyData(db);

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

    public void createDummyData(AppDatabase db){

        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        Student student = new Student("Xheneta", "Hasani", "01.12.1998", 1243729153, "Pjeter Bogdani", 3, "xheneta.hasani@gmail.com", 044122111, "044567767", "Sherafedin");
        db.studentDao().insertStudent(student);

        Afati afatiOne = new Afati("Janari");
        Afati afatiTwo = new Afati("Prilli");
        Afati afatiThree = new Afati("Qershori");
        Afati afatiFour = new Afati("Shtatori");
        Afati afatiFive = new Afati("Nëntori");
        db.afatiDao().insertAfat(afatiOne);
        db.afatiDao().insertAfat(afatiTwo);
        db.afatiDao().insertAfat(afatiThree);
        db.afatiDao().insertAfat(afatiFour);
        db.afatiDao().insertAfat(afatiFive);

        Menza menza = new Menza("Menza e Konvikteve","42.655133248742494","21.164502724017698");
        db.menzaDao().insertMenza(menza);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date test = cal.getTime();
        Provimi provimiOne = new Provimi("daa",1,test);
        Provimi provimiTwo = new Provimi("mikro",1,test);
        Provimi provimiThree = new Provimi("algoritme",2,test);
        Provimi provimiFour = new Provimi("baza",2,test);
        Provimi provimiFive = new Provimi("qarqe",3,test);
        Provimi provimiSix = new Provimi("sinjale",3,test);
        Provimi provimiSeven = new Provimi("programim",4,test);
        Provimi provimiEight = new Provimi("ndermarresi",4,test);
        Provimi provimiNine = new Provimi("php",5,test);
        Provimi provimiTen = new Provimi("inxhinieri softuerike",5,test);
        db.provimiDao().insertProvimi(provimiOne);
        db.provimiDao().insertProvimi(provimiTwo);
        db.provimiDao().insertProvimi(provimiThree);
        db.provimiDao().insertProvimi(provimiFour);
        db.provimiDao().insertProvimi(provimiFive);
        db.provimiDao().insertProvimi(provimiSix);
        db.provimiDao().insertProvimi(provimiSeven);
        db.provimiDao().insertProvimi(provimiEight);
        db.provimiDao().insertProvimi(provimiNine);
        db.provimiDao().insertProvimi(provimiTen);

        Calendar calOne = Calendar.getInstance();
        calOne.set(Calendar.YEAR, 2023);
        calOne.set(Calendar.MONTH, Calendar.JUNE);
        calOne.set(Calendar.DAY_OF_MONTH, 23);
        Date testOne = calOne.getTime();

        Calendar calTwo = Calendar.getInstance();
        calTwo.set(Calendar.YEAR, 2023);
        calTwo.set(Calendar.MONTH, Calendar.JUNE);
        calTwo.set(Calendar.DAY_OF_MONTH, 22);
        Date testTwo = calTwo.getTime();

        EventDTO eventDTOone = new EventDTO("Ligjerate daa",testOne);
        EventDTO eventDTOtwo = new EventDTO("Ushtrime databaze", testTwo);

        db.eventDtoDao().insertEventDto(eventDTOone);
        db.eventDtoDao().insertEventDto(eventDTOtwo);
    }

}