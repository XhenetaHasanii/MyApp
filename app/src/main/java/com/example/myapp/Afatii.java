package com.example.myapp;

import java.util.Arrays;

public class Afatii {
    String examPeriods[];

    public Afatii(String[] examPeriods) {
        this.examPeriods = examPeriods;
    }

    @Override
    public String toString() {
        return "Afatii{" +
                "examPeriods=" + Arrays.toString(examPeriods) +
                '}';
    }

    public String[] getExamPeriods() {
        return examPeriods;
    }

    public void setExamPeriods(String[] examPeriods) {
        this.examPeriods = examPeriods;
    }
}
