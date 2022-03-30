package com.miu.ea.kamalale.exam1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String city;
    private String state;
    @OneToMany(mappedBy = "address",
            targetEntity = Person.class)
    private List<Person> personList = new ArrayList<>();

    public Address() {

    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public void addPersonToList(Person person){
        personList.add(person);
        person.setAddress(this);
    }
    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
