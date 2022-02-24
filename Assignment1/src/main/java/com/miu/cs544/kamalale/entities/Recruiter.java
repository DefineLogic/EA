package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recruiter extends Company {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Client> clientList;

    public Recruiter() {
    }

    public Recruiter(String name, String address, List<Client> clientList) {
        super(name, address);
        this.clientList = clientList;
    }
}
