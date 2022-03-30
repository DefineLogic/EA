package com.miu.cs544.kamalale.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class Address {

    private String streetNo;
    private String city;
    private String state;
    private String zipCode;

    public Address() {

    }

    public Address(String streetNo, String city, String state, String zipCode) {
        this.streetNo = streetNo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo='" + streetNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }


}
