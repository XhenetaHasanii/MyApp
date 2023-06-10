package com.example.myapp.entities;

import com.example.myapp.entities.Provimi;

import java.util.List;

public class Afati {

    private String examPeriodName;
    private List<Provimi> periodExams;

    public Afati(String examPeriodName, List<Provimi> periodExams) {
        this.examPeriodName = examPeriodName;
        this.periodExams = periodExams;
    }

    public Afati() {
    }

    @Override
    public String toString() {
        return "Afati{" +
                "examPeriodName='" + examPeriodName + '\'' +
                ", periodExams=" + periodExams +
                '}';
    }

    public void setExamPeriodName(String examPeriodName) {
        this.examPeriodName = examPeriodName;
    }

    public void setPeriodExams(List<Provimi> periodExams) {
        this.periodExams = periodExams;
    }

    public String getExamPeriodName() {
        return examPeriodName;
    }

    public List<Provimi> getPeriodExams() {
        return periodExams;
    }


}
