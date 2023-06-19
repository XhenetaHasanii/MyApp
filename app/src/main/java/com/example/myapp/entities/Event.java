package com.example.myapp.entities;

import java.time.LocalDate;
import java.time.LocalTime;


public class Event {

    private String eventName;

    private LocalDate eventDate;

    private LocalTime eventTime;

    public Event(String name, LocalDate date, LocalTime time) {
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
    }

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }
}
