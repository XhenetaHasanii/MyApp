package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.SAXResult;


public class JanuaryPeriod extends AppCompatActivity {
        public static final String EXTRA_DATA="EXTRA_DATA";
        List<Exams> periodExams;
        Parcel in;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_january_period);

            /*ArrayList<String> exams = new ArrayList<>();
            exams.add("Programimi i orientuar ne objekte,  20.01");
            exams.add("PHP,  23.01");
            exams.add("Database,  30.01");
            exams.add("Internet,  19.01");
            exams.add("Matematike3,  01.02");
            exams.add("Inxhinieri Softuerike,  03.02");
            exams.add("Elektronike,  08.02");
*/

            ListView listView1 = (ListView) findViewById(R.id.list);

            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     List<Exams> readListFrom; {
                        Parcelable[] parcelables = in.readParcelableArray(
                                Afati.class.getClassLoader());
                        List<Exams> periodExams = new ArrayList<>(parcelables.length);
                        for (Parcelable parcelable : parcelables) {
                            periodExams.add((Exams) parcelable);
                        }

                    }
                    ListView listView1 = (ListView) findViewById(R.id.list);
                    periodExams = getIntent().getParcelableArrayListExtra(EXTRA_DATA);

                }
            });


           /* listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    showCustomPopup();
                }
            });
        }

        private void showCustomPopup() {
            final Dialog dialog = new Dialog(JanuaryPeriod.this);
            dialog.setContentView(R.layout.custom_popup);
            dialog.setCancelable(true);

            TextView textViewMessage = dialog.findViewById(R.id.textViewMessage);
            Button buttonClose = dialog.findViewById(R.id.buttonClose);

            textViewMessage.setText("Shume suksese ne provim!");

            buttonClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }

    }*/
        }}