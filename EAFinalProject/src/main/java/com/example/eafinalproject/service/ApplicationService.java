package com.example.eafinalproject.service;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.exception.ExceptionHandler;
import com.example.eafinalproject.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    public Application getApplication(int applicationId) {
        if (applicationRepository.findById(applicationId).isPresent()) {
            return applicationRepository.findById(applicationId).get();
        } else {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
        return null;
    }

    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteApplication(int applicationId) {
        try {
            applicationRepository.deleteById(applicationId);
        }
        catch(EmptyResultDataAccessException e){
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }
}
