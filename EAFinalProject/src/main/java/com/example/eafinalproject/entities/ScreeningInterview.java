package com.example.eafinalproject.entities;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class ScreeningInterview extends Interview {

    private String name;
    private String result;

    public ScreeningInterview() {

    }

    public ScreeningInterview(Date date, long phoneNumber, String email, String name, String result) {
        super(date, phoneNumber, email);
        this.name = name;
        this.result = result;
    }

    @Override
    public String toString() {
        return super.toString() + "ScreeningInterview{" +
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
