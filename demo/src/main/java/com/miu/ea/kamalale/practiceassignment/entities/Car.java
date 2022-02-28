package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.*;

@Entity
public class Car extends  Vechile{

    private int millage;

    public Car() {
    }

    public Car(int year, int millage) {
        super(year);
        this.millage = millage;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", year=" + year +
                ", factory=" + getFactory() +
                ", person=" + getPerson() +
                "millage=" + millage +
                '}';
    }
}
