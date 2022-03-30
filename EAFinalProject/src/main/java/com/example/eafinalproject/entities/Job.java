package com.example.eafinalproject.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="Job.findJobsByInterviewCount",query="Select j from Job j where size(j.interviewList) >= 2")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @Version
    private int version;

    private String title;

    private double salary;

    @JsonInclude()
    @Transient
    private int applicationId;

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

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
