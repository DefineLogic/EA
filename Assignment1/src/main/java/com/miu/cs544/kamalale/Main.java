package com.miu.cs544.kamalale;

import com.miu.cs544.kamalale.entities.Job;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;


class Main {

    private static EntityManagerFactory efact = Persistence.createEntityManagerFactory("jobPU");
    private static EntityManager eman = efact.createEntityManager();

    public static void main(String[] args) {
        try {
            create();
            read();
            update();
            delete();

        } finally {
            eman.close();
            efact.close();
        }
    }

    private static void create() {
        System.out.println("Begin Create");
        eman.getTransaction().begin();
        Job job1 = new Job("Software Developer I", 60000,null,null,null);
        Job job2 = new Job("Software Developer II", 80000,null,null,null);
        Job job3 = new Job("Senior Software Developer", 120000,null,null,null);
        eman.persist(job1);
        eman.persist(job2);
        eman.persist(job3);
        eman.getTransaction().commit();
        System.out.println("End Create");
    }

    private static void read() {
        System.out.println("Begin Read");
        eman.getTransaction().begin();
        Query q = eman.createQuery("from Job e", Job.class);
        List<Job> jobs = q.getResultList();
        jobs.forEach(job-> System.out.println("Id ::"+job.getId()+" Title ::"+job.getTitle()+
                " Salary ::"+job.getSalary()));
        eman.getTransaction().commit();
        System.out.println("End Read");
    }

    private static void update() {
        System.out.println("Begin Update");
        eman.getTransaction().begin();
        Job job = eman.find(Job.class, 1);
        System.out.println("Job id :: " + job.getId());
        System.out.println("Job title :: " + job.getTitle());
        System.out.println("Job salary :: " + job.getSalary());

        job.setTitle("Software Developer One");
        eman.getTransaction().commit();

        System.out.println("End Update");

    }

    private static void delete() {
        System.out.println("Begin Delete");
        eman.getTransaction().begin();
        Job job = eman.find(Job.class, 2);
        eman.remove(job);
        eman.getTransaction().commit();
        System.out.println("End Delete");

    }
}