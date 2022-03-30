package com.miu.ea.kamalale.exam1.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Actor extends Person{

    @Enumerated
    private Gender gender;

    private int experience;

    public Actor() {
    }

    public Actor(String name, int age, Gender gender, int experience) {
        super(name, age);
        this.gender = gender;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + getId() +
                "name=" + getName() +
                "age=" + getAge() +
                "address=" + getAddress() +
                "gender=" + gender +
                ", experience=" + experience +
                '}';
    }
}
