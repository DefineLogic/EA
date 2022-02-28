package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.*;

@Entity
@NamedNativeQuery(name="Vechile.findAllCars",query="select * from Vechile c where DTYPE = 'car'",resultClass = Vechile.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vechile {

    @Id
    @GeneratedValue
    protected int id;
    protected int year;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="factory_id")
    private Factory factory;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Vechile() {
    }

    public Vechile(int year) {
        this.year = year;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
