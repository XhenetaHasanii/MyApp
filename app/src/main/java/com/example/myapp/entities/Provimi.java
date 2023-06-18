package com.example.myapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Provimi")
public class Provimi {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="examName")
    private String examName;
    @ColumnInfo(name="examPeriodId")
    private int examPeriodId;
    @ColumnInfo(name="examTime")
    private Date examTime;

    public Provimi(String examName, int examPeriodId, Date examTime) {
        this.examName = examName;
        this.examPeriodId = examPeriodId;
        this.examTime = examTime;
    }

    public Provimi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamPeriodId() {
        return examPeriodId;
    }

    public void setExamPeriodId(int examPeriodId) {
        this.examPeriodId = examPeriodId;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
}
