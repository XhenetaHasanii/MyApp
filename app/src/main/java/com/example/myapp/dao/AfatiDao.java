package com.example.myapp.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.entities.Afati;

import java.util.List;

@Dao
public interface AfatiDao {

    @Query("SELECT * FROM Afati")
    List<Afati> getAllAfatis();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAfat(Afati afati);
}
