package com.example.myapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.entities.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class ProfiliActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Student> personalInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setElevation(0);
        personalInformation = new ArrayList<>();

        TextView emri = findViewById(R.id.emri);
        TextView mbiemri = findViewById(R.id.mbiemri);
        TextView imella = findViewById(R.id.email);
        TextView viti = findViewById(R.id.vitiStudimeve);
        TextView datelindja=findViewById(R.id.datelindja);
        TextView telNumri=findViewById(R.id.tel);
        TextView adresa=findViewById(R.id.adresa);
        TextView numriPersonal=findViewById(R.id.nrPersonal);
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        readData(new ProfiliActivity.FirestoreCallback() {
            @Override
            public void onCallback(List<Student> list) {

                String firstName = "";
                String lastName = "";
                Integer yearLevel = 0;
                String address="";
                String birthDate="";
                Integer phoneNumber=0;
                Integer personalNumber=0;
                for (Student student : list) {
                    firstName = student.getFirstName();
                    lastName = student.getLastName();
                    yearLevel = student.getYearLevel();
                    address=student.getAddress();
                    birthDate=student.getBirthDate();
                    phoneNumber=student.getPhoneNumber();
                    personalNumber=student.getPersonalNumber();
                }
                emri.setText(firstName);
                mbiemri.setText(lastName);
                viti.setText(Integer.toString(yearLevel));
                imella.setText(userEmail);
                datelindja.setText(birthDate);
                 telNumri.setText(Integer.toString(phoneNumber));
                adresa.setText(address);
                 numriPersonal.setText(Integer.toString(personalNumber));


            }
        });
    }

    private void readData(ProfiliActivity.FirestoreCallback firestoreCallBack) {
        CollectionReference collectionRef = db.collection("student");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        personalInformation.add(doc.toObject(Student.class));
                    }
                    firestoreCallBack.onCallback(personalInformation);
                }
            }
        });
    }

    private interface FirestoreCallback {
        void onCallback(List<Student> list);
    }

}