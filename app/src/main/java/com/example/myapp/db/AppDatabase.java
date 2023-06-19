package com.example.myapp.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.myapp.converters.Converters;
import com.example.myapp.dao.AfatiDao;
import com.example.myapp.dao.EventDtoDao;
import com.example.myapp.dao.GeneralDao;
import com.example.myapp.dao.MenzaDao;
import com.example.myapp.dao.ProvimiDao;
import com.example.myapp.dao.StudentDao;
import com.example.myapp.dto.EventDTO;
import com.example.myapp.entities.Afati;
import com.example.myapp.entities.Event;
import com.example.myapp.entities.Menza;
import com.example.myapp.entities.Provimi;
import com.example.myapp.entities.Student;

@Database(entities = {Student.class, Menza.class, Afati.class, Provimi.class, EventDTO.class}, version = 5, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();
    public abstract GeneralDao generalDao();

    public abstract MenzaDao menzaDao();

    public abstract AfatiDao afatiDao();

    public abstract ProvimiDao provimiDao();

    public abstract EventDtoDao eventDtoDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "UP-Campus")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}