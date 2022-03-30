package com.example.eafinalproject.repository;

import com.example.eafinalproject.entities.Company;
import com.example.eafinalproject.entities.Job;
import com.example.eafinalproject.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("Select a.job.company from Application a where a.id= ?1")
    Company findByApplicationId(int applicationId);

    @Query("Select c from Company c where c.address.state = ?1")
    List<Company> findCompanyByAddressState(String state);

    @Query(value = "Select c.* from Job j join company c on j.salary>?1 and c.company_type= 'Recruiter' ", nativeQuery = true)
    List<Recruiter> findRecruiterBySalaryGreaterThan(double salary);

    @Query("Select j from Job j where size(j.interviewList) >= ?1")
    List<Job> findJobsWithInterviewsMoreAndEqualThan(int num);

    public void deleteById(int id);

}
