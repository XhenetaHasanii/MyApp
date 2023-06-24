package com.example.myapp.dao;


import static org.junit.Assert.assertEquals;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class StudentDaoTest {

    private StudentDao studentDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        db.clearAllTables();
        db.generalDao().resetSequenceTable();
        studentDao = db.studentDao();
    }

    @After
    public void closeDb(){
        db.close();
    }

    @Test
    public void writeAndReadStudentTest(){

        Student student = new Student("testFirstName", "test", "test", 1991232, "test", 3, "xheneta.hasani@gmail.com", 044122111, "044567767", "testParent");
        studentDao.insertStudent(student);
        List<Student> byName = studentDao.getAllStudents();
        assertEquals("testFirstName",byName.get(0).getFirstName());
    }


}
