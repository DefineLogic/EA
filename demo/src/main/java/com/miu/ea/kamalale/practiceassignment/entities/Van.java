package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Van extends  Vechile{

    @Enumerated
    private Color color;

    public Van() {
    }

    public Van(int year,  Color color) {
        super(year);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vans{" +
                "id=" + id +
                ", year=" + year +
                ", factory=" + getFactory() +
                ", person=" + getPerson() +
                "color=" + color +
                '}';
    }
}
