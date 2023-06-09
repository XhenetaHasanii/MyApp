package com.example.myapp;

import java.util.Date;

public class EventDTO {

    private String emri;
    private Date orari;

    public EventDTO(String name, Date orari) {
        this.emri = name;
        this.orari = orari;
    }
    public EventDTO() {
    }

    public String getEmri() {
        return emri;
    }

    public Date getOrari() {
        return orari;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setOrari(Date orari) {
        this.orari = orari;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "emri='" + emri + '\'' +
                ", orari=" + orari +
                '}';
    }
}
