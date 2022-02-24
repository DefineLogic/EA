package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Application {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade= CascadeType.ALL)
    private Job job;

    private Date date;

    private double resumeVersion;

    public Application() {
    }

    public Application(Job job, Date date, double resumeVersion) {
        this.job = job;
        this.date = date;
        this.resumeVersion = resumeVersion;
    }
}
