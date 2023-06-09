package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Student> personalInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.exam_period_list);
        personalInformation = new ArrayList<>();

        readData(new Profile.FirestoreCallback() {
            @Override
            public void onCallback(List<Student> list) {

                personalInformation.addAll(list);

                for (Student student : personalInformation) {
                    String firstName = student.getFirstName();
                    String lastName = student.getLastName();
                    // Process student data as needed


                }
                AdapterStudent adapter = new AdapterStudent(Profile.this, personalInformation);
                ListView listView = (ListView) findViewById(R.id.list_view);

                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    }
                });


            }
        });
    }

    ;


    private void readData(Profile.FirestoreCallback firestoreCallBack) {
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


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);

    }


}