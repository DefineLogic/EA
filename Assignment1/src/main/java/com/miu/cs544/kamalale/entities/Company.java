package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@NamedQuery(name="Company.sameState",query="Select c from Company c where c.address.state = :state_param")
@DiscriminatorColumn(name="Company_Type")
public class Company {

    @Id
    @GeneratedValue
    private int id;
     String name;

    @Embedded
    Address address;

    public Company() {
    }

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
