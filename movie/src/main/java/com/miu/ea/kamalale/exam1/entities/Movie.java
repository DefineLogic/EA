package com.miu.ea.kamalale.exam1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Movie.findPersonsByMovie",query="select m.personList from Movie m where m.title = :title")
public class Movie {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private int year;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Person> personList;

    public Movie() {
    }

    public Movie(String title, int year, List<Person> personList) {
        this.title = title;
        this.year = year;
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", personList=" + personList +
                '}';
    }
}
