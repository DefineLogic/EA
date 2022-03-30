package com.example.eafinalproject.jms;

import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JobReceiver {

    @Autowired
    JobService jobService;

    @JmsListener(destination = "${springjms.mqName}")
    public void receive(Job job) {
        System.out.println("Received Job object:" + job);
        jobService.addJob(job.getApplicationId(),job);
    }
}
