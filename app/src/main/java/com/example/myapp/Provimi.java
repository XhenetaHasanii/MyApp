package com.example.myapp;

import java.util.Date;

public class Provimi {

    private String examName;
    private Date examTime;

    public Provimi(String examName, Date examTime) {
        this.examName = examName;
        this.examTime = examTime;
    }

    public Provimi() {
    }

    @Override
    public String toString() {
        return "Provimi{" +
                "examName='" + examName + '\'' +
                ", examTime=" + examTime +
                '}';
    }

    public String getExamName() {
        return examName;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
}
