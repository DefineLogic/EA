package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name= "Factory.findFactoryByYearGreaterThan",query=" select f from Factory f where f.year > :year")
public class Factory {

    @Id
    @GeneratedValue
    private int id;
    private int year;
    private int totalEmp;

    @OneToMany
    private List<Vechile> vechiles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Insurance insurance;

    public Factory() {
    }

    public Factory(int year, int totalEmp, Insurance insurance) {
        this.year = year;
        this.totalEmp = totalEmp;
        this.insurance = insurance;
    }

    public List<Vechile> getVechiles() {
        return vechiles;
    }
    public void addVechiles(Vechile vechile){
        vechiles.add(vechile);
        vechile.setFactory(this);
    }
    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", year=" + year +
                ", totalEmp=" + totalEmp +
                ", insurance=" + insurance +
                '}';
    }
}
