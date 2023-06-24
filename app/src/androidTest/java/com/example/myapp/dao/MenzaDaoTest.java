package com.example.myapp.dao;

import static org.junit.Assert.*;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Menza;
import org.junit.After;
import org.junit.Before;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MenzaDaoTest {
    private MenzaDao menzaDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        menzaDao = db.menzaDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void writeAndReadMenzaTest(){
        Menza menza = new Menza("testMenza","222","333");
        menzaDao.insertMenza(menza);
        List<Menza> byName = menzaDao.getAllMenza();
        assertEquals("testMenza",byName.get(0).getEmri());
    }

}