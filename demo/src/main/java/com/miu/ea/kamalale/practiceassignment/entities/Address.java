package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Address {

   private String street;
   private String state;
   private String city;

    public Address() {
    }

    public Address(String street, String state, String city) {
        this.street = street;
        this.state = state;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
