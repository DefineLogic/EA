package com.miu.cs544.kamalale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

@Entity
public class TechnicalInterview extends Interview{

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
}
