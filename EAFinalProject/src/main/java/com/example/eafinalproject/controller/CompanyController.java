package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Company;
import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.entities.Recruiter;
import com.example.eafinalproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/applications/{applicationId}/companies")
    public Company getCompany(@PathVariable int applicationId){
        return companyService.getCompany(applicationId);
    }

    @DeleteMapping("/applications/{applicationId}/companies")
    public void deleteCompany(@PathVariable int applicationId){
        companyService.deleteCompany(applicationId);
    }

    @PostMapping("/applications/{applicationId}/companies")
    public void addCompany(@PathVariable int applicationId, @RequestBody Company companyDetails){
        companyService.addCompany(applicationId,companyDetails);
    }

    @PutMapping("/applications/{applicationId}/companies")
    public void updateCompany(@PathVariable int applicationId, @RequestBody Company companyDetails){
        companyService.updateCompany(applicationId,companyDetails);
    }

    @GetMapping("companies/state/{state}")
    public List<Company> getCompanyByState(@PathVariable String state){
        return companyService.getCompanyByState(state);
    }

    @GetMapping("companies/salaryGreaterThan/{salary}")
    public List<Recruiter> findRecruiterBySalaryGreaterThan(@PathVariable Double salary){
        return companyService.findRecruiterBySalaryGreaterThan(salary);
    }

    @GetMapping("jobs/interviewsMoreAndEqualThan/{num}")
    public List<Job> findJobsWithInterviewsMoreAndEqualThan(@PathVariable int num){
        return companyService.findJobsWithInterviewsMoreAndEqualThan(num);
    }
}
