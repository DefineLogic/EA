package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)

public class Company {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
