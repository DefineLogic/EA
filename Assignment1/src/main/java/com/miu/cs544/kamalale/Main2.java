package com.miu.cs544.kamalale;

import com.miu.cs544.kamalale.entities.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main2 {
    private static EntityManagerFactory efact = Persistence.createEntityManagerFactory("jobPU");
    private static EntityManager eman = efact.createEntityManager();

    public static void main(String[] args) {
        try {
            initializeData();
            eman.getTransaction().begin();

            String queryStr = "SELECT j.* FROM Job j join Application a WHERE j.id = a.job_id";
            Query query = eman.createNativeQuery(queryStr,Job.class);
            List<Job> result = query.getResultList();
            result.forEach(System.out::println);

            int noOfDays = 7; //i.e 1 week
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            Date aWeekDate = calendar.getTime();
            Query query2 = eman.createQuery("SELECT i FROM Interview i " +
                    "WHERE i.date < :aWeekDate");
            query2.setParameter("aWeekDate",aWeekDate);
            List<Interview> interviewList = query2.getResultList();
            interviewList.forEach(System.out::println);

            TypedQuery<Company> query3 = eman.createNamedQuery("Company.sameState", Company.class);
            query3.setParameter("state_param","Karnataka");
            List<Company> companyList = query3.getResultList();
            companyList.forEach(System.out::println);

            TypedQuery<Recruiter> query4 = eman.createNamedQuery("Job.findRecruiterBySalary", Recruiter.class);
            query4.setParameter("salary",50000);
            query4.setParameter("recruiter",Recruiter.class);
            List<Recruiter> recruiterList = query4.getResultList();
            recruiterList.forEach(System.out::println);

            TypedQuery<Job> query5 = eman.createNamedQuery("Job.findJobsByInterviewCount", Job.class);
            List<Job> jobList = query5.getResultList();
            jobList.forEach(System.out::println);

            CriteriaBuilder criteriaBuilder = eman.getCriteriaBuilder();
            CriteriaQuery<Job> criQuery = criteriaBuilder.createQuery(Job.class);
            Root<Job> rootJob = criQuery.from(Job.class);
            Predicate salaryPredicate = criteriaBuilder.greaterThan(rootJob.get("salary"),90000);
            Predicate companyStatePredicate = criteriaBuilder.equal(rootJob.get("company").get("address").get("state"),
                    "Karnataka");
            Predicate andPredicate = criteriaBuilder.and(salaryPredicate,companyStatePredicate);
            criQuery.where(andPredicate);
            TypedQuery<Job> query6 = eman.createQuery(criQuery);
            List<Job> jobList2 = query6.getResultList();
            jobList2.forEach(System.out::println);




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
        Client client1 = new Client("Morgan Stanley",new Address("RMZ EcoWorld","Bangalore",
                "Karnataka","560103"), "dedicated to local" +
                " and global communities since 1935","Do the right thing",
                "https://www.morganstanley.com/");
        Client client2 = new Client("Goldman Sachs",new Address("Helios Tech Park","Bangalore",
                "Karnataka","560103")," to advance sustainable " +
                "economic growth and financial opportunity across the globe","Our people are our greatest " +
                "asset.","https://www.goldmansachs.com/");
        Client client3 = new Client("JPMC",new Address("Prestige Tech Park","Bangalore",
                "Karnataka","560087")," to enable more people to " +
                "contribute to and share in the rewards of a growing economy","aspire to be the best" +
                "asset.","https://www.jpmorganchase.com/");
        clientList.add(client1);
        clientList.add(client2);

        Recruiter recruiter1 = new Recruiter("Synechron",new Address("Global Technology Park",
                "Bangalore", "Karnataka","560103"),clientList);
//        eman.persist(recruiter1);
//        eman.persist(client3);

        //Interviews
        ScreeningInterview si = new ScreeningInterview(new Date(122,01,27), 6412330002L, "kale@miu.com",
                "KamalAle", "Pass");
        TechnicalInterview ti = new TechnicalInterview(new Date(122,02,02), 6412330002L, "kale@miu.com",
                12,
                Location.ONLINE,
                "implement a LinkedHashMap");
        ScreeningInterview si2 = new ScreeningInterview(new Date(122,01,27), 6412330002L, "kale@miu.com",
                "KamalAle", "Pass");
        TechnicalInterview ti2 = new TechnicalInterview(new Date(122,02,02), 6412330002L, "kale@miu.com",
                12,
                Location.ONLINE,
                "implement a LinkedHashMap");
        HiringManagerInterview hi = new HiringManagerInterview(new Date(122,02,24), 6412330002L,
                "kale@miu.com", 5, new Date(2022,04,01));
        List<Interview> interviewList = new ArrayList<>();
        interviewList.add(si);
        interviewList.add(ti);

        List<Interview> interviewList2 = new ArrayList<>();
        interviewList2.add(si2);
        interviewList2.add(ti2);

        Job job1 = new Job("Software Developer I",60000,skillList,recruiter1,interviewList);
        Job job2 = new Job("Engineering Analyst",90000,skillList,client1,interviewList2);
        Job job3 = new Job("Technology Analyst",100000,skillList,client2,null);
        Job job4 = new Job("Technical Analyst",80000,skillList,client3,null);


        Application application1 = new Application(job1,new Date(),1.0);
        Application application2 = new Application(job2,new Date(),1.0);
        Application application3 = new Application(job3,new Date(),1.0);
        Application application4 = new Application(job4,new Date(),1.0);


        eman.persist(application1);
        eman.persist(application2);
        eman.persist(application3);
        eman.persist(application4);



//        eman.persist(si);
//        eman.persist(ti);
//        eman.persist(hi);

        eman.getTransaction().commit();
    }
}
