package com.example.springboot2.controller;

import com.example.springboot2.entity.Student;
import com.example.springboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Long studentId)  {
        return studentService.getOne(studentId);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Student> addOneStudent (@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        long savedStudentId = savedStudent.getId();
        URI saveStudentUri =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{student_id}").buildAndExpand(savedStudentId).toUri();
        return ResponseEntity.created(saveStudentUri).build();
    }
}
