package com.miu.ea.kamalale.exam1.entities;

import javax.persistence.*;

@Entity
@NamedQuery(name="Person.findAllActorInAState",query="select p from Person p where " +
        "TYPE(p) = :actor and p.address.state = :state")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Person() {
    }

    public Person(String name, int age ) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
