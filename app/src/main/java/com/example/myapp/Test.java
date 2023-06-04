package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Test extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Student> personalInformation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile);

            Button button = findViewById(R.id.personalInformationn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    personalinformation();
                }
            });
            readData(new FirestoreCallback() {
                @Override
                public void onCallback(List<Student> list) {
                    personalInformation.addAll(list);

                    for (Student student : personalInformation) {
                        String firstName = student.getFirstName();
                        String lastName = student.getLastName();
                        // Process student data as needed
                    }
                }
            });
        }
    private void readData(Test.FirestoreCallback firestoreCallback) {
        CollectionReference collectionRef = db.collection("student");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        personalInformation.add(doc.toObject(Student.class));
                    }
                    firestoreCallback.onCallback(personalInformation);
                }
            }
        });
    }
    public void personalinformation() {
        for (Student student : personalInformation) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            // Process student data as needed
        }
    }

    private interface FirestoreCallback {
        void onCallback(List<Student> list);
    }
}