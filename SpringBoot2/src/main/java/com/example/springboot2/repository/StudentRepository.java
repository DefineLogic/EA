package com.example.springboot2.repository;

import com.example.springboot2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> , JpaSpecificationExecutor<Student> {

    public Student findByName(String name);
    public Student save(Student student);
    public Student findByGpa(float gpa);
    public Student findByNameAndGpa(String name, float gpa);
    @Query("Select s from Student s where s.gpa > ?1")
    public List<Student> findStudentsWithGpaGreaterThan(float gpa);

    public List<Student> findFailing();

    @Query(value = "select * from student where gpa >= ?1", nativeQuery = true)
    public List<Student> findStudentsWithGpaGreaterThanOrEqual(float gpa);





}
