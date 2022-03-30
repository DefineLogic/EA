package com.example.eafinalproject.repository;

import com.example.eafinalproject.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job,Integer> , JpaSpecificationExecutor<Job> {

    @Query("Select a.job from Application a where a.id= ?1")
    Job getJobByApplicationId(int applicationId);

    public void deleteById(int id);


}
