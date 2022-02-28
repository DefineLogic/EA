package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Insurance {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Embedded
    private Address address;

    public Insurance() {
    }

    public Insurance(String name, Address address) {
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
