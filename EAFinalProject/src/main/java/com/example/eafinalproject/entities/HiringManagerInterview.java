package com.example.eafinalproject.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class HiringManagerInterview extends Interview {

    int teamSize;
    Date startDate;

    public HiringManagerInterview() {

    }

    public HiringManagerInterview(Date date, long phoneNumber, String email, int teamSize, Date startDate) {
        super(date, phoneNumber, email);
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return super.toString() + "HiringManagerInterview{" +
                "teamSize=" + teamSize +
                ", startDate=" + startDate +
                '}';
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
