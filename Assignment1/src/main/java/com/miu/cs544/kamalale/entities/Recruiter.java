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

    public Recruiter(String name, Address address, List<Client> clientList) {
        super(name, address);
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "id=" + id +
                ", clientList=" + clientList +
                '}';
    }
}
