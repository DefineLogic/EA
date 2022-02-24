package com.miu.cs544.kamalale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client extends Company{

    @Id
    @GeneratedValue
    private int id;

    private String mission;
    private String reason;
    private String website;

    public Client() {
    }

    public Client(String name, String address, String mission, String reason, String website) {
        super(name, address);
        this.mission = mission;
        this.reason = reason;
        this.website = website;
    }
}
