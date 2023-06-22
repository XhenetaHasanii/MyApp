package com.example.myapp.DataLayerTests;

import android.content.Context;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import androidx.core.app.*;

import com.example.myapp.db.AppDatabase;

import java.io.IOException;


@RunWith(JUnit4.class)
public class EventEntityTests {
/*
    private UserDao userDao;
    private TestDatabase db;

    @Before
    public void createDb() {
        Context context = Application.getInstrumentation().getTargetContext()
        db = AppDatabase.getDbInstance(this.getAppl);
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        /*User user = TestUtil.createUser(3);
        user.setName("george");
        userDao.insert(user);
        List<User> byName = userDao.findUsersByName("george");
        assertEquals(byName.get(0), equalTo(user));


    }
 */
}
