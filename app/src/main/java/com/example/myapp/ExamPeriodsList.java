package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ExamPeriodsList extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Afati> examPeriodDocuments;
    private FirebaseFirestore firestoreInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        ListView listView = findViewById(R.id.list_view);
        examPeriodDocuments = new ArrayList<>();
        readData(new FirestoreCallback() {
            @Override
            public void onCallback(List<Afati> list) {
                String[] examPeriods = new String[list.size()];
                for (int i = 0; i < list.size(); ++i) {
                    examPeriods[i] = list.get(i).getExamPeriodName();
                }
                for (String s : examPeriods) {
                    System.out.println(s);
                }

                CustomBaseAdapter adapter = new CustomBaseAdapter(ExamPeriodsList.this, examPeriods);

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
                    }
                });
            }
        });
    }

    private void readData(FirestoreCallback firestoreCallback) {
        CollectionReference collectionRef = db.collection("afati");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        examPeriodDocuments.add(doc.toObject(Afati.class));
                    }
                    firestoreCallback.onCallback(examPeriodDocuments);
                }
            }
        });
        System.out.println("finished reading data");
    }

    private interface FirestoreCallback {
        void onCallback(List<Afati> list);
    }
}
