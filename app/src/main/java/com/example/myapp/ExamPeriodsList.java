package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamPeriodsList extends AppCompatActivity {
     FirebaseFirestore firestoreInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        ListView listView = (ListView) findViewById(R.id.list_view);
        firestoreInstance = FirebaseFirestore.getInstance();

        List<Afatii> examPeriodDocuments=new ArrayList<>();
        String examPeriods[] = new String[examPeriodDocuments.size()];
        CollectionReference collectionRef = firestoreInstance.collection("afatii");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot doc:task.getResult()){
                        examPeriodDocuments.add(doc.toObject(Afatii.class));
                    }
                }
            }
        });


        for (int i =0;i<examPeriodDocuments.size();++i){
            examPeriods[i]= Arrays.toString(examPeriodDocuments.get(i).getExamPeriods());
        }

// instantiate the custom list adapter
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, examPeriods);

// get the ListView and attach the adapter
        ListView itemsListView = (ListView) findViewById(R.id.list_view);
        itemsListView.setAdapter(adapter);

         itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (examPeriods[0] == "Janar") {
                  examPeriodDocuments.get(0);

                } else if (examPeriods[1] == "Prill") {
                    examPeriodDocuments.get(1);
                } else if (examPeriods[2] == "Qershor") {
                  examPeriodDocuments.get(2);
                } else if (examPeriods[3] == "Shtator") {
                 examPeriodDocuments.get(3);
                } else if (examPeriods[4] == "Nentor") {
                   examPeriodDocuments.get(4);
                }
                ;
            }
        });
    }}











