package com.example.myapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapp.dto.EventDTO;

import java.util.List;

@Dao
public interface EventDtoDao {

    @Query("SELECT * FROM EventDto")
    List<EventDTO> getAllEventDtos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEventDto(EventDTO eventDTO);
}
