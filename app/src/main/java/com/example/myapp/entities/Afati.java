package com.example.myapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Afati")
public class Afati {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="examPeriodName")
    private String examPeriodName;

    public Afati(String examPeriodName) {
        this.examPeriodName = examPeriodName;
    }

    public Afati() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamPeriodName() {
        return examPeriodName;
    }

    public void setExamPeriodName(String examPeriodName) {
        this.examPeriodName = examPeriodName;
    }

    @Override
    public String toString() {
        return "Afati{" +
                "id=" + id +
                ", examPeriodName='" + examPeriodName + '\'' +
                '}';
    }
}
