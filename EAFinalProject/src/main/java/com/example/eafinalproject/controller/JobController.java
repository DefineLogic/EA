package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.jms.JobSender;
import com.example.eafinalproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    JobSender jobSender;

    @GetMapping("applications/{applicationId}/job")
    public Job getJob(@PathVariable int applicationId){
        return jobService.getJob(applicationId);
    }

    @DeleteMapping("applications/{applicationId}/job")
    public void deleteJob(@PathVariable int applicationId){
        jobService.deleteJob(applicationId);
    }

    @PostMapping("applications/{applicationId}/job")
    public void addJob(@PathVariable int applicationId, @RequestBody Job job){
        job.setApplicationId(applicationId);
        jobSender.send(job);
    }

    @PutMapping("applications/{applicationId}/job")
    public void updateJob(@PathVariable int applicationId, @RequestBody Job job){
        jobService.updateJob(applicationId,job);
    }

    @GetMapping("jobs")
    public List<Job> getJobsInParticularStateAndSalaryGreaterThan(@RequestParam String state, @RequestParam Double salary){
        return jobService.getJobsInParticularStateAndSalaryGreaterThan(state,salary);
    }

}
