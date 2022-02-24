package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Interview {

    @Id
    @GeneratedValue
    private int id;

    private Date date;
    private long phoneNumber;
    private String email;

    public Interview() {
    }

    public Interview(Date date, long phoneNumber, String email) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
