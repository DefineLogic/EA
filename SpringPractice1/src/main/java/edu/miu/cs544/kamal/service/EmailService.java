package edu.miu.cs544.kamal.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class EmailService {

    public EmailService(){

    }

    public void sendEmail(){
        System.out.println("sending email......");
    }

}
