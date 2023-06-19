package com.example.myapp.activities;

import static com.example.myapp.helpers.CalendarUtils.daysInWeekArray;
import static com.example.myapp.helpers.CalendarUtils.monthYearFromDate;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.adapters.CalendarAdapter;
import com.example.myapp.adapters.EventAdapter;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.dto.EventDTO;
import com.example.myapp.entities.Event;
import com.example.myapp.helpers.CalendarUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;
    private List<EventDTO> eventDTOs;

    private List<Event> allEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        allEvents = new ArrayList<>();

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Calendar calOne = Calendar.getInstance();
        calOne.set(Calendar.YEAR, 2023);
        calOne.set(Calendar.MONTH, Calendar.JUNE);
        calOne.set(Calendar.DAY_OF_MONTH, 19);
        Date testOne = calOne.getTime();

        Calendar calTwo = Calendar.getInstance();
        calTwo.set(Calendar.YEAR, 2023);
        calTwo.set(Calendar.MONTH, Calendar.JUNE);
        calTwo.set(Calendar.DAY_OF_MONTH, 20);
        Date testTwo = calTwo.getTime();

        EventDTO eventDTOone = new EventDTO("Ligjerate daa",testOne);
        EventDTO eventDTOtwo = new EventDTO("Ushtrime databaze", testTwo);

        db.eventDtoDao().insertEventDto(eventDTOone);
        db.eventDtoDao().insertEventDto(eventDTOtwo);

        eventDTOs = db.eventDtoDao().getAllEventDtos();

        for (int i = 0; i < eventDTOs.size();++i){
            LocalDateTime tempDate = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                tempDate = LocalDateTime.ofInstant(eventDTOs.get(i).getEventDate().toInstant(), ZoneId.systemDefault());
            }
            LocalDate temp2 = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                temp2 = tempDate.toLocalDate();
            }
            LocalTime temp3 = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                temp3 = tempDate.toLocalTime();
            }
            String tempName = eventDTOs.get(i).getEventName();
            Event tempEvent = new Event(tempName,temp2,temp3);
            allEvents.add(tempEvent);
        }

                initWidgets();
                setWeekView();

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
        ArrayList<Event> dailyEvents = eventsForDate(CalendarUtils.selectedDate,allEvents);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

    public ArrayList<Event> eventsForDate(LocalDate date, List<Event> eventsList ) {
        ArrayList<Event> events = new ArrayList<>();

        for (Event event : eventsList) {
            if (event.getEventDate().equals(date))
                events.add(event);
        }

        return events;
    }

}
