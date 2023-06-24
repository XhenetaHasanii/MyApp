package com.example.myapp.dao;

import static org.junit.Assert.assertEquals;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Afati;
import com.example.myapp.entities.Provimi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ProvimiDaoTest {

    private ProvimiDao provimiDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        db.afatiDao().insertAfat(new Afati("Janar"));
        provimiDao = db.provimiDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void writeAndReadProvimetOfSpecificAfatiTest(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date test = cal.getTime();

        Provimi provimi = new Provimi("daa",1,test);
        provimiDao.insertProvimi(provimi);
        List<Provimi> byName = provimiDao.getAllProvimetOfSpecificAfati("Janar");
        assertEquals("daa",byName.get(0).getExamName());
    }


}
