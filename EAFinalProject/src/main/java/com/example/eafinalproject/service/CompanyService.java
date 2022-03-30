package com.example.eafinalproject.service;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.entities.Company;
import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.entities.Recruiter;
import com.example.eafinalproject.exception.ExceptionHandler;
import com.example.eafinalproject.repository.ApplicationRepository;
import com.example.eafinalproject.repository.CompanyRepository;
import com.example.eafinalproject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    JobRepository jobRepository;

    public Company getCompany(int applicationId) {

        Company company = companyRepository.findByApplicationId(applicationId);
        if (company != null) {
            return company;
        } else {
            ExceptionHandler.handleException("Company not found for Id:" + applicationId);
        }
        return null;
    }

    public void deleteCompany(int applicationId) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                Company company = application.getJob().getCompany();
                application.getJob().setCompany(null);
                applicationRepository.save(application);
                companyRepository.deleteById(company.id);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void addCompany(int applicationId, Company companyDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                Company company = application.getJob().getCompany();
                application.getJob().setCompany(companyDetails);
                companyRepository.deleteById(company.id);
                applicationRepository.save(application);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void updateCompany(int applicationId, Company companyDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                Company company = application.getJob().getCompany();
                application.getJob().setCompany(companyDetails);
                applicationRepository.save(application);
                companyRepository.deleteById(company.id);
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public List<Company> getCompanyByState(String state) {
        return companyRepository.findCompanyByAddressState(state);
    }

    public List<Recruiter> findRecruiterBySalaryGreaterThan(Double salary) {
        return companyRepository.findRecruiterBySalaryGreaterThan(salary);
    }

    public List<Job> findJobsWithInterviewsMoreAndEqualThan(int num) {
        return companyRepository.findJobsWithInterviewsMoreAndEqualThan(num);
    }
}
