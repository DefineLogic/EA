package com.miu.cs544.kamalale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int experience;
    private String description;
    private String language;

    public Skill() {
    }

    public Skill(String name, int experience, String description, String language) {
        this.name = name;
        this.experience = experience;
        this.description = description;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
