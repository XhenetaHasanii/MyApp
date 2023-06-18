package com.example.myapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.entities.Menza;

import java.util.List;

@Dao
public interface MenzaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMenza(Menza menza);

    @Query("SELECT * FROM Menza")
    List<Menza> getAllMenza();
}
