package com.example.springboot2.service;

import com.example.springboot2.entity.Student;
import com.example.springboot2.repository.StudentRepository;
import com.example.springboot2.repository.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    StudentManager studentManager;

    @Autowired
    StudentRepository studentRepository;

//    @Override
//    public void run(String... args) throws Exception {
//        studentManager.insert(new Student("Jack",3.3f));
//        studentManager.insert(new Student("Jill",3.3f));
//        studentManager.insert(new Student("John",3.3f));
//        studentManager.insert(new Student("Jim",3.3f));
//        studentManager.insert(new Student("Jane",3.3f));
//
//    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student("Jill", 3.1f));
        studentRepository.save(new Student("John", 3.2f));
        studentRepository.save(new Student("Jim", 3.3f));
        studentRepository.save(new Student("Jack", 3.4f));
        studentRepository.save(new Student("Jane", 3.5f));

        System.out.println(studentRepository.findByName("Jack"));
        System.out.println(studentRepository.findStudentsWithGpaGreaterThan(3.2f));
        System.out.println(studentRepository.findFailing());
        System.out.println(studentRepository.findStudentsWithGpaGreaterThanOrEqual(3.3f));
        System.out.println("GreaterThan 3.0f "+studentRepository.findAll(StudentSpecification.hasGpaGreaterThan(3.0f)));
        System.out.println("lessThan 3.2f "+studentRepository.findAll(StudentSpecification.hasGpaLessThan(3.2f)));
//        System.out.println("lessThan 3.2f and greaterThan 3.0f"+studentRepository.findAll
//                (StudentSpecification.hasGpaLessThan(3.2f))); // use streams
    }
}
