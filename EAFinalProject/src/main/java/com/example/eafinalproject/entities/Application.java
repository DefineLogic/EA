package com.example.eafinalproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @Version
    private int version;

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

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", job=" + job +
                ", date=" + date +
                ", resumeVersion=" + resumeVersion +
                '}';
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(double resumeVersion) {
        this.resumeVersion = resumeVersion;
    }
}
