package com.miu.ea.kamalale.practiceassignment.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "Person.findVechileByPerson", query = "select p.vechileList from Person p  where p.name = :name")
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST,
            targetEntity = Vechile.class)
    private List<Vechile> vechileList = new ArrayList<>();

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addToVechileList(Vechile vechile) {
        vechileList.add(vechile);
        vechile.setPerson(this);
    }

    public void removeFromVechileList(Vechile vechile) {
        vechileList.remove(vechile);
        vechile.setPerson(null);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
