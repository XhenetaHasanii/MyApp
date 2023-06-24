package com.example.myapp.dao;


import static org.junit.Assert.assertEquals;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.myapp.db.AppDatabase;
import com.example.myapp.dto.EventDTO;
import com.example.myapp.entities.Menza;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class EventDTODaoTest {

    private EventDtoDao eventDtoDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        eventDtoDao = db.eventDtoDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void writeAndReadEventsTest(){
        Calendar calOne = Calendar.getInstance();
        calOne.set(Calendar.YEAR, 2023);
        calOne.set(Calendar.MONTH, Calendar.JUNE);
        calOne.set(Calendar.DAY_OF_MONTH, 23);
        Date testOne = calOne.getTime();

        EventDTO eventDTO = new EventDTO("testEvent",testOne);
        eventDtoDao.insertEventDto(eventDTO);
        List<EventDTO> byName = eventDtoDao.getAllEventDtos();
        assertEquals("testEvent",byName.get(0).getEventName());
    }


}
