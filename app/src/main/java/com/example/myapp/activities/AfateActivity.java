package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Afati;
import java.util.List;

public class AfateActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTxt;

    private String[] items;
    private List<Afati> examPeriods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_period_dropmenu);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        examPeriods = db.afatiDao().getAllAfatis();


        items = new String[examPeriods.size()];
        for (int i = 0; i < examPeriods.size(); ++i) {
            items[i] = examPeriods.get(i).getExamPeriodName();
        }
        ArrayAdapter<String> adapterItems;
        adapterItems = new ArrayAdapter<String>(AfateActivity.this, R.layout.list_item, items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = (String) adapterItems.getItem(position);
                        Intent intent = new Intent(AfateActivity.this, ProvimetActivity.class);
                        intent.putExtra("afati",item);
                        startActivity(intent);
            }
        });
    }

}