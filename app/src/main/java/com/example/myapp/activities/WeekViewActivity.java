package com.example.myapp.activities;

import static com.example.myapp.helpers.CalendarUtils.daysInWeekArray;
import static com.example.myapp.helpers.CalendarUtils.monthYearFromDate;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapp.helpers.CalendarUtils;
import com.example.myapp.R;
import com.example.myapp.adapters.CalendarAdapter;
import com.example.myapp.adapters.EventAdapter;
import com.example.myapp.dto.EventDTO;
import com.example.myapp.entities.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<EventDTO> eventDTOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        eventDTOs = new ArrayList<>();
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);

        readData(new WeekViewActivity.FirestoreCallback(){
            @Override
            public void onCallback(List<EventDTO> list) {
                for (int i = 0; i < list.size();++i){
                    LocalDateTime tempDate = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        tempDate = LocalDateTime.ofInstant(list.get(i).getOrari().toInstant(), ZoneId.systemDefault());
                    }
                    LocalDate temp2 = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        temp2 = tempDate.toLocalDate();
                    }
                    LocalTime temp3 = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        temp3 = tempDate.toLocalTime();
                    }
                    String tempName = list.get(i).getEmri();
                        Event tempEvent = new Event(tempName,temp2,temp3);
                        Event.eventsList.add(tempEvent);
                        dailyEvents.add(tempEvent);
                }
                initWidgets();
                setWeekView();
            }
        });


    }

    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();
    }


    public void nextWeekAction(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        }
        setWeekView();
    }

    public void previousWeekAction(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        }
        setWeekView();
    }

    private void setEventAdpater() {
        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

    private void readData(WeekViewActivity.FirestoreCallback firestoreCallback) {
        CollectionReference collectionRef = db.collection("event");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        eventDTOs.add(doc.toObject(EventDTO.class));
                    }
                    firestoreCallback.onCallback(eventDTOs);
                }
            }
        });
    }

    private interface FirestoreCallback {
        void onCallback(List<EventDTO> list);
    }
}
