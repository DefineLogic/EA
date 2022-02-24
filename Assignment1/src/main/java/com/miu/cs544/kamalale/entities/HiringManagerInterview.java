package com.miu.cs544.kamalale.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class HiringManagerInterview extends  Interview{

    int teamSize;
    Date startDate;

    public HiringManagerInterview(){

    }

    public HiringManagerInterview(Date date, long phoneNumber, String email, int teamSize, Date startDate) {
        super(date, phoneNumber, email);
        this.teamSize = teamSize;
        this.startDate = startDate;
    }
}
