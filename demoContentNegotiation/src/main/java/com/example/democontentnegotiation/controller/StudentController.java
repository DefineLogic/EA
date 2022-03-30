package com.example.democontentnegotiation.controller;

import com.example.democontentnegotiation.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class StudentController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("kamal","3.0");
    }

    @GetMapping("greeting/{name}")
    public String greetings(@PathVariable String name,@RequestHeader(name="accept-language" ,required = false) Locale locale ){
        System.out.println("devtools working...");
        System.out.println("devtools working...");
        return messageSource.getMessage("greeting.message",null, locale)+ " "+name;
    }
}
