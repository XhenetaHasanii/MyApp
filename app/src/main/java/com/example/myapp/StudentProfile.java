package com.example.myapp;

import static com.example.myapp.R.*;

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

public class StudentProfile extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Student> personalInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        personalInformation = new ArrayList<>();

                readData(new FirestoreCallback() {
                    @Override
                    public void onCallback(List<Student> list) {
                        String[] personalInformation = new String[list.size()];
                        for (int i = 0; i < list.size(); ++i) {
                            personalInformation[i] = list.get(i).getFirstName() + "" + list.get(i).getLastName();


                        }
                        for (String s : personalInformation) {
                            System.out.println(s);
                        }
                        AdapterStudent adapter = new AdapterStudent(StudentProfile.this, personalInformation);
                         ListView listView=(ListView)findViewById(id.list_view);

                        listView.setAdapter(adapter);
                       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                           @Override
                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                           }
                       });


                    }});}



    private void readData(StudentProfile.FirestoreCallback firestoreCallback) {
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

   public void  backToLogin(){

   }
  public void  personalinformation(){

  }

    private interface FirestoreCallback {
        void onCallback(List<Student> list);
    }




}