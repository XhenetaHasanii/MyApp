package com.example.myapp.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class AfatiAndProvimi {

    @Embedded public Afati afati;
    @Relation(
            parentColumn = "id",
            entityColumn = "examPeriodId"
    )
    public List<Provimi> exams;

}