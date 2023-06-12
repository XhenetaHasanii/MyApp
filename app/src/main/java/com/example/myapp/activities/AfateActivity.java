package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.JanuaryPeriod;
import com.example.myapp.R;
import com.example.myapp.adapters.AfateAdapter;
import com.example.myapp.entities.Afati;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class AfateActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    List<String> items;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Afati> examPeriodDocuments;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.exam_period_list);
            items=new ArrayList<>();
            examPeriodDocuments = new ArrayList<>();
            autoCompleteTxt = findViewById(R.id.auto_complete_txt);
            readData(new FirestoreCallback() {
                         @Override
                         public void onCallback(List<Afati> list) {
                           /*  String[] examPeriods = new String[list.size()];*/
                             List<String> examPeriods=new ArrayList<>();
                             for (int i = 0; i < list.size(); ++i) {
                                 /*examPeriods[i] = list.get(i).getExamPeriodName();*/
                                 examPeriods.add(list.get(i).getExamPeriodName());
                             }
                             adapterItems = new ArrayAdapter<String>(AfateActivity.this, R.layout.list_item,examPeriods);
                             autoCompleteTxt.setAdapter(adapterItems);

                             /*Intent intent=new Intent(AfateActivity.this,JanuaryPeriod.class);
                             intent.putParcelableArrayListExtra("provimet", (ArrayList<? extends Parcelable>) list.get(0).getPeriodExams());
                             startActivity(intent);
*/

                         }
                     } );



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