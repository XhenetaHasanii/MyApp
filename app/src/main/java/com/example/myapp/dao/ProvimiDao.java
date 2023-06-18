package com.example.myapp.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.entities.Provimi;

import java.util.List;

@Dao
public interface ProvimiDao {

    @Query("SELECT * FROM Provimi p, Afati a WHERE p.examPeriodId = a.id AND a.examPeriodName = :periodName")
    List<Provimi> getAllProvimetOfSpecificAfati(String periodName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProvimi(Provimi provimi);
}
