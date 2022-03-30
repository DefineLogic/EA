package com.example.springboot2.service;

import com.example.springboot2.entity.Student;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class StudentManager {

    @PersistenceContext
    private EntityManager em;

    public long insert(Student student) {
        em.persist(student);
        return student.getId();
    }

    public EntityManager getEm() {
        return em;
    }
}
