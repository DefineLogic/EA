package com.example.eafinalproject.service;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.exception.ExceptionHandler;
import com.example.eafinalproject.repository.ApplicationRepository;
import com.example.eafinalproject.repository.JobRepository;
import com.example.eafinalproject.repository.JobSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    public Job getJob(int applicationId) {
        return jobRepository.getJobByApplicationId(applicationId);
    }

    public void deleteJob(int applicationId) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null) {
                Job job = application.getJob();
                application.setJob(null);
                applicationRepository.save(application);
                jobRepository.deleteById(job.id);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void addJob(int applicationId, Job job) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null) {
                application.setJob(job);
                applicationRepository.save(application);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void updateJob(int applicationId, Job job) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null) {
                application.setJob(job);
                applicationRepository.save(application);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public List<Job> getJobsInParticularStateAndSalaryGreaterThan(String state, Double salary) {
        return jobRepository.findAll(JobSpecification.hasGpaGreaterThan(salary, state));
    }
}
