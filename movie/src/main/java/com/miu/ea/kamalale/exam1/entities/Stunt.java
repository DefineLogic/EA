package com.miu.ea.kamalale.exam1.entities;

import javax.persistence.Entity;

@Entity
public class Stunt extends Person{

    private float height;

    private float weight;

    public Stunt() {
    }

    public Stunt(String name, int age, float height, float weight) {
        super(name, age);
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Stunt{" +
                "id=" + getId() +
                "name=" + getName() +
                "age=" + getAge() +
                "address=" + getAddress() +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
