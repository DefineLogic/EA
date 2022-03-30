package com.example.eafinalproject.service;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.entities.Interview;
import com.example.eafinalproject.exception.ExceptionHandler;
import com.example.eafinalproject.repository.ApplicationRepository;
import com.example.eafinalproject.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    public List<Interview> getInterviews(int applicationId) {
        return interviewRepository.getByApplicationId(applicationId);
    }


    public void deleteInterviews(int applicationId) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                List<Interview> interviewList = application.getJob().getInterviewList();
                application.getJob().setInterviewList(null);
                applicationRepository.save(application);
                for (Interview interview : interviewList) {
                    interviewRepository.deleteById(interview.id);
                }
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void addInterviews(int applicationId, List<Interview> interviewDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                application.getJob().setInterviewList(interviewDetails);
                applicationRepository.save(application);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void updateInterviews(int applicationId, List<Interview> interviewDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                application.getJob().getInterviewList().addAll(interviewDetails);
                applicationRepository.save(application);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

}
