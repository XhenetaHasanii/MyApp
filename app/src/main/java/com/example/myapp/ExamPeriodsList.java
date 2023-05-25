package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
     FirebaseFirestore firestoreInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_list);
        ListView listView = (ListView) findViewById(R.id.list_view);
        firestoreInstance = FirebaseFirestore.getInstance();

        List<Afati> examPeriodDocuments=new ArrayList<>();
        String examPeriods[] = new String[examPeriodDocuments.size()];
        CollectionReference collectionRef = firestoreInstance.collection("afati");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot doc:task.getResult()){
                        examPeriodDocuments.add(doc.toObject(Afati.class));
                    }
                }
            }
        });


        for (int i =0;i<examPeriodDocuments.size();++i){
            examPeriods[i]=examPeriodDocuments.get(i).getExamPeriodName();
        }

// instantiate the custom list adapter
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, examPeriods);

// get the ListView and attach the adapter
        ListView itemsListView = (ListView) findViewById(R.id.list_view);
        itemsListView.setAdapter(adapter);

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (examPeriods[position]=="Janar"){
                    Intent intent=new Intent(ExamPeriodsList.this,JanuaryPeriod.class);
                    startActivity(intent);

                } else if (examPeriods[position]=="Prill") {
                    Intent intent1=new Intent(ExamPeriodsList.this,AprilPeriod.class);
                    startActivity(intent1);

                }
                else if (examPeriods[position]=="Qershor") {
                    Intent intent2=new Intent(ExamPeriodsList.this,JunePeriod.class);
                    startActivity(intent2);}
                else if (examPeriods[position]=="Shtator") {
                    Intent intent3=new Intent(ExamPeriodsList.this,SeptemberPeriod.class);
                    startActivity(intent3);}

                else if (examPeriods[position]=="Nentor") {
                    Intent intent4=new Intent(ExamPeriodsList.this,NovemberPeriod.class);
                    startActivity(intent4);}
            }
        });
    }


}







