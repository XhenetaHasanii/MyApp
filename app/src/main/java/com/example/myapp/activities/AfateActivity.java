package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.entities.Afati;
import com.example.myapp.entities.Provimi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AfateActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTxt;

    private String[] items;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Afati> examPeriodDocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        examPeriodDocuments = new ArrayList<>();
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        readData(new FirestoreCallback() {
            @Override
            public void onCallback(List<Afati> list) {
                items = new String[list.size()];
                for (int i = 0; i < list.size(); ++i) {
                    items[i] = list.get(i).getExamPeriodName();
                }
                ArrayAdapter<String> adapterItems;
                adapterItems = new ArrayAdapter<String>(AfateActivity.this, R.layout.list_item, items);
                autoCompleteTxt.setAdapter(adapterItems);
                autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = (String) adapterItems.getItem(position);
                        List<Provimi> tempList = null;
                        for (Afati a : examPeriodDocuments) {
                            if (a.getExamPeriodName().equals(item)) {
                                tempList = a.getPeriodExams();
                            }
                        }
                        Intent intent = new Intent(AfateActivity.this, ProvimetActivity.class);
                        intent.putParcelableArrayListExtra("provimet", (ArrayList<? extends Parcelable>) tempList);
                        startActivity(intent);
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
    }

    private interface FirestoreCallback {
        void onCallback(List<Afati> list);
    }
}