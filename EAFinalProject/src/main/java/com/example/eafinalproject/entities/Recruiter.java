package com.example.eafinalproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("Recruiter")
public class Recruiter extends Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    @Version
    private int version;

    @OneToMany(cascade = CascadeType.ALL)
    List<Client> clientList;

    public Recruiter() {
    }

    public Recruiter(String name, Address address, List<Client> clientList) {
        super(name, address);
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "id=" + id +
                ", clientList=" + clientList +
                '}';
    }


    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
