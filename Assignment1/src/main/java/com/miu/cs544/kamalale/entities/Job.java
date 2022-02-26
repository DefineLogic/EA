package com.miu.cs544.kamalale.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Job.findRecruiterBySalary",query="Select j.company from Job j where j.salary > :salary " +
        "and TYPE(j.company) = :recruiter")
//@NamedQuery(name="Job.findJobsByInterviewCount",query="Select j from job j join d.interview on j.id = " +
//        " j.interview.job_id group by j.interview.job_id having count(*) > :counts " )
@NamedQuery(name="Job.findJobsByInterviewCount",query="Select j from Job j where size(j.interviewList) >= 2")
public class Job {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private double salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    List<Skill> skillList;

    @OneToOne(cascade = CascadeType.ALL)
    Company company;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    List<Interview> interviewList;

    public Job() {
    }

    public Job(String title, double salary, List<Skill> skillList, Company company,List<Interview> interviewList) {
        this.title = title;
        this.salary = salary;
        this.skillList = skillList;
        this.company = company;
        this.interviewList = interviewList;
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", skillList=" + skillList +
                ", company=" + company +
                ", interviewList=" + interviewList +
                '}';
    }
}
