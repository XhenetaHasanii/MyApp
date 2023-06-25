package com.example.myapp.dao;


import static org.junit.Assert.assertEquals;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Afati;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class AfatiDaoTest {

    private AfatiDao afatiDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        afatiDao = db.afatiDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void writeAndReadAfatiTest(){
        Afati afati = new Afati("Janari");
        afatiDao.insertAfat(afati);
        List<Afati> byName = afatiDao.getAllAfatis();
        assertEquals("Janari",byName.get(0).getExamPeriodName());
    }
}
