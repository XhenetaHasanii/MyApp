package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
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
        TextView imella = findViewById(R.id.imella);
        TextView viti = findViewById(R.id.viti);
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        readData(new ProfileActivity.FirestoreCallback() {
            @Override
            public void onCallback(List<Student> list) {

                String firstName = "";
                String lastName = "";
                Integer yearLevel = 0;
                for (Student student : list) {
                    firstName = student.getFirstName();
                    lastName = student.getLastName();
                    yearLevel = student.getYearLevel();
                }
                emri.setText(firstName);
                mbiemri.setText(lastName);
                viti.setText(Integer.toString(yearLevel));
                imella.setText(userEmail);

            }
        });
    }

    private void readData(ProfileActivity.FirestoreCallback firestoreCallBack) {
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