package com.example.eafinalproject.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Entity
public class TechnicalInterview extends Interview {

    private int duration;

    @Enumerated(EnumType.STRING)
    private Location location;

    private String Questions;

    public TechnicalInterview() {

    }

    public TechnicalInterview(Date date, long phoneNumber, String email, int duration, Location location, String questions) {
        super(date, phoneNumber, email);
        this.duration = duration;
        this.location = location;
        Questions = questions;
    }

    @Override
    public String toString() {
        return super.toString() + "TechnicalInterview{" +
                "duration=" + duration +
                ", location=" + location +
                ", Questions='" + Questions + '\'' +
                '}';
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }
}
