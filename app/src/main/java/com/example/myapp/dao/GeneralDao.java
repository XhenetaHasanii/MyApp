package com.example.myapp.dao;

import androidx.room.Dao;
import androidx.room.Query;


@Dao
public interface GeneralDao {

    @Query("DELETE FROM sqlite_sequence")
    public int resetSequenceTable();

}
