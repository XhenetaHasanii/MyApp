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
        Student student = new Student("Xheneta", "Hasani", "01.12.1998", 1243729153, "Pjetër Bogdani", 3, "xheneta.h@gmail.com", 044567767, "044567767", "Sherafedin");
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

        Calendar januarCalendar = Calendar.getInstance();
        januarCalendar.set(Calendar.YEAR, 2023);
        januarCalendar.set(Calendar.MONTH, Calendar.JANUARY);
        januarCalendar.set(Calendar.DAY_OF_MONTH, 14);
        januarCalendar.set(Calendar.HOUR_OF_DAY,9);
        januarCalendar.set(Calendar.MINUTE,00);
        januarCalendar.set(Calendar.SECOND,0);
        Date janarDate = januarCalendar.getTime();
        Provimi provimiOneJanar = new Provimi("Dizajni dhe Analiza e Algoritmeve",1,janarDate);
        Provimi provimiTwoJanar = new Provimi("Mikroprocesorë dhe Mikrokontrollerë",1,janarDate);
        Provimi provimiThreeJanar = new Provimi("Programimi I",1,janarDate);
        Provimi provimiFourJanar = new Provimi("Bazat e Elektroteknikës",1,janarDate);
        Provimi provimiFiveJanar = new Provimi("Sinjale dhe Sisteme",1,janarDate);
        Provimi provimiSixJanar = new Provimi("Matematikë I",1,janarDate);


        Calendar aprilCalendar = Calendar.getInstance();
        aprilCalendar.set(Calendar.YEAR, 2023);
        aprilCalendar.set(Calendar.MONTH, Calendar.APRIL);
        aprilCalendar.set(Calendar.DAY_OF_MONTH, 11);
        aprilCalendar.set(Calendar.HOUR_OF_DAY,9);
        aprilCalendar.set(Calendar.MINUTE,00);
        aprilCalendar.set(Calendar.SECOND,0);
        Date aprilDate = aprilCalendar.getTime();
        Provimi provimiOnePrill = new Provimi("Dizajni dhe Analiza e Algoritmeve",2,aprilDate);
        Provimi provimiTwoPrill = new Provimi("Mikroprocesorë dhe Mikrokontrollerë",2,aprilDate);
        Provimi provimiThreePrill = new Provimi("Programimi I",2,aprilDate);
        Provimi provimiFourPrill = new Provimi("Bazat e Elektroteknikës",2,aprilDate);
        Provimi provimiFivePrill = new Provimi("Sinjale dhe Sisteme",2,aprilDate);
        Provimi provimiSixPrill = new Provimi("Matematikë I",2,aprilDate);

        Calendar juneCalendar = Calendar.getInstance();
        juneCalendar.set(Calendar.YEAR, 2023);
        juneCalendar.set(Calendar.MONTH, Calendar.JUNE);
        juneCalendar.set(Calendar.DAY_OF_MONTH, 20);
        juneCalendar.set(Calendar.HOUR_OF_DAY,9);
        juneCalendar.set(Calendar.MINUTE,00);
        juneCalendar.set(Calendar.SECOND,0);
        Date juneDate = juneCalendar.getTime();
        Provimi provimiOneQershor = new Provimi("Dizajni dhe Analiza e Algoritmeve",3,juneDate);
        Provimi provimiTwoQershor = new Provimi("Mikroprocesorë dhe Mikrokontrollerë",3,juneDate);
        Provimi provimiThreeQershor = new Provimi("Programimi I",3,juneDate);
        Provimi provimiFourQershor = new Provimi("Bazat e Elektroteknikës",3,juneDate);
        Provimi provimiFiveQershor = new Provimi("Sinjale dhe Sisteme",3,juneDate);
        Provimi provimiSixQershor = new Provimi("Matematikë I",3,juneDate);

        Calendar septemberCalendar = Calendar.getInstance();
        septemberCalendar.set(Calendar.YEAR, 2023);
        septemberCalendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
        septemberCalendar.set(Calendar.DAY_OF_MONTH, 17);
        septemberCalendar.set(Calendar.HOUR_OF_DAY,9);
        septemberCalendar.set(Calendar.MINUTE,00);
        septemberCalendar.set(Calendar.SECOND,0);
        Date septemberDate = septemberCalendar.getTime();
        Provimi provimiOneShtator = new Provimi("Dizajni dhe Analiza e Algoritmeve",4,septemberDate);
        Provimi provimiTwoShtator = new Provimi("Mikroprocesorë dhe Mikrokontrollerë",4,septemberDate);
        Provimi provimiThreeShtator = new Provimi("Programimi I",4,septemberDate);
        Provimi provimiFourShtator = new Provimi("Bazat e Elektroteknikës",4,septemberDate);
        Provimi provimiFiveShtator = new Provimi("Sinjale dhe Sisteme",4,septemberDate);
        Provimi provimiSixShtator = new Provimi("Matematikë I",4,septemberDate);

        Calendar novemberCalendar = Calendar.getInstance();
        novemberCalendar.set(Calendar.YEAR, 2023);
        novemberCalendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        novemberCalendar.set(Calendar.DAY_OF_MONTH, 23);
        novemberCalendar.set(Calendar.HOUR_OF_DAY,9);
        novemberCalendar.set(Calendar.MINUTE,00);
        novemberCalendar.set(Calendar.SECOND,0);
        Date novemberDate = novemberCalendar.getTime();
        Provimi provimiOneNentor = new Provimi("Dizajni dhe Analiza e Algoritmeve",5,novemberDate);
        Provimi provimiTwoNentor = new Provimi("Mikroprocesorë dhe Mikrokontrollerë",5,novemberDate);
        Provimi provimiThreeNentor = new Provimi("Programimi I",5,novemberDate);
        Provimi provimiFourNentor = new Provimi("Bazat e Elektroteknikës",5,novemberDate);
        Provimi provimiFiveNentor = new Provimi("Sinjale dhe Sisteme",5,novemberDate);
        Provimi provimiSixNentor = new Provimi("Matematikë I",5,novemberDate);

        db.provimiDao().insertProvimi(provimiOneJanar);
        db.provimiDao().insertProvimi(provimiTwoJanar);
        db.provimiDao().insertProvimi(provimiThreeJanar);
        db.provimiDao().insertProvimi(provimiFourJanar);
        db.provimiDao().insertProvimi(provimiFiveJanar);
        db.provimiDao().insertProvimi(provimiSixJanar);

        db.provimiDao().insertProvimi(provimiOnePrill);
        db.provimiDao().insertProvimi(provimiTwoPrill);
        db.provimiDao().insertProvimi(provimiThreePrill);
        db.provimiDao().insertProvimi(provimiFourPrill);
        db.provimiDao().insertProvimi(provimiFivePrill);
        db.provimiDao().insertProvimi(provimiSixPrill);

        db.provimiDao().insertProvimi(provimiOneQershor);
        db.provimiDao().insertProvimi(provimiTwoQershor);
        db.provimiDao().insertProvimi(provimiThreeQershor);
        db.provimiDao().insertProvimi(provimiFourQershor);
        db.provimiDao().insertProvimi(provimiFiveQershor);
        db.provimiDao().insertProvimi(provimiSixQershor);

        db.provimiDao().insertProvimi(provimiOneShtator);
        db.provimiDao().insertProvimi(provimiTwoShtator);
        db.provimiDao().insertProvimi(provimiThreeShtator);
        db.provimiDao().insertProvimi(provimiFourShtator);
        db.provimiDao().insertProvimi(provimiFiveShtator);
        db.provimiDao().insertProvimi(provimiSixShtator);

        db.provimiDao().insertProvimi(provimiOneNentor);
        db.provimiDao().insertProvimi(provimiTwoNentor);
        db.provimiDao().insertProvimi(provimiThreeNentor);
        db.provimiDao().insertProvimi(provimiFourNentor);
        db.provimiDao().insertProvimi(provimiFiveNentor);
        db.provimiDao().insertProvimi(provimiSixNentor);

        Calendar calOne = Calendar.getInstance();
        calOne.set(Calendar.YEAR, 2023);
        calOne.set(Calendar.MONTH, Calendar.JUNE);
        calOne.set(Calendar.DAY_OF_MONTH, 29);
        Date testOne = calOne.getTime();

        Calendar calTwo = Calendar.getInstance();
        calTwo.set(Calendar.YEAR, 2023);
        calTwo.set(Calendar.MONTH, Calendar.JUNE);
        calTwo.set(Calendar.DAY_OF_MONTH, 30);
        Date testTwo = calTwo.getTime();

        EventDTO eventDTOone = new EventDTO("Ligjërate daa",testOne);
        EventDTO eventDTOtwo = new EventDTO("Ushtrime databazë", testTwo);

        db.eventDtoDao().insertEventDto(eventDTOone);
        db.eventDtoDao().insertEventDto(eventDTOtwo);
        db.close();
    }

}