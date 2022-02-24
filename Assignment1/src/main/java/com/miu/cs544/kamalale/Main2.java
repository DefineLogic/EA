package com.miu.cs544.kamalale;

import com.miu.cs544.kamalale.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main2 {
    private static EntityManagerFactory efact = Persistence.createEntityManagerFactory("jobPU");
    private static EntityManager eman = efact.createEntityManager();

    public static void main(String[] args) {
        try {
            initializeData();
            eman.getTransaction().begin();
 //           String queryStr = "SELECT j.* FROM Job AS j WHERE j.Grade = 3.0";
//            TypedQuery<Student> query = em.createNativeQuery(queryStr,Student.class);
//            List<Student> result = query.getResultList();
//            Stream<Student> students = result.getResultSttream();
            eman.getTransaction().commit();
        } finally {
            eman.close();
            efact.close();
        }
    }

    private static void initializeData() {
        eman.getTransaction().begin();

        List<Skill> skillList = new ArrayList<>();
        Skill skill1 = new Skill("frontend",2,"Design and implementation of UI",
                "Angular");
        Skill skill2 = new Skill("frontend",2,"Design and implementation of UI",
                "React");
        skillList.add(skill1);
        skillList.add(skill2);

        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client("Morgan Stanley","Helios Tech Park","dedicated to local" +
                " and global communities since 1935","Do the right thing",
                "https://www.morganstanley.com/");
        Client client2 = new Client("Goldman Sachs","RMZ Ecoworld"," to advance sustainable " +
                "economic growth and financial opportunity across the globe","Our people are our greatest " +
                "asset.","https://www.goldmansachs.com/");
        Client client3 = new Client("JPMC","Prestige Tech Park"," to enable more people to " +
                "contribute to and share in the rewards of a growing economy","aspire to be the best" +
                "asset.","https://www.jpmorganchase.com/");
        clientList.add(client1);
        clientList.add(client2);

        Recruiter recruiter1 = new Recruiter("Synechron","Global Technology Park",clientList);
        eman.persist(recruiter1);
        eman.persist(client3);

        Job job1 = new Job("Software Developer I",60000,skillList,recruiter1);
        Job job2 = new Job("Engineering Analyst",90000,skillList,client1);
        Job job3 = new Job("Technology Analyst",100000,skillList,client2);
        Job job4 = new Job("Technical Analyst",80000,skillList,client3);


        Application application1 = new Application(job1,new Date(),1.0);
        Application application2 = new Application(job2,new Date(),1.0);
        Application application3 = new Application(job3,new Date(),1.0);
        Application application4 = new Application(job4,new Date(),1.0);


        eman.persist(application1);
        eman.persist(application2);
        eman.persist(application3);
        eman.persist(application4);


        //Interviews
        ScreeningInterview si = new ScreeningInterview(new Date(), 6412330002L, "kale@miu.com",
                "KamalAle", "Pass");
        TechnicalInterview ti = new TechnicalInterview(new Date(), 6412330002L, "kale@miu.com",
                12,
                Location.ONLINE,
                "implement a LinkedHashMap");
        HiringManagerInterview hi = new HiringManagerInterview(new Date(), 6412330002L,
                "kale@miu.com", 5, new Date());
        eman.persist(si);
        eman.persist(ti);
        eman.persist(hi);

        eman.getTransaction().commit();
    }
}
