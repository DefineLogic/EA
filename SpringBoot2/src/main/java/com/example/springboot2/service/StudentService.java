package com.example.springboot2.service;

import com.example.springboot2.entity.Student;
import com.example.springboot2.exception.StudentNotFoundException;
import com.example.springboot2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getOne(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = null;
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            handleException(studentId);
        }
        return studentOptional.get();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }
    private void handleException(Long studentId) {
        throw new StudentNotFoundException(studentId);
    }

}
