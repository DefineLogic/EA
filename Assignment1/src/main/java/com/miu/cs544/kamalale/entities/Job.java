package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private double salary;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="jid")
    List<Skill> skillList;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="cid")
    Company company;

    public Job() {
    }

    public Job(String title, double salary,List<Skill> skillList,Company company) {
        this.title = title;
        this.salary = salary;
        this.skillList = skillList;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
