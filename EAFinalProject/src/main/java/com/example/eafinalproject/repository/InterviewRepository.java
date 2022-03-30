package com.example.eafinalproject.repository;

import com.example.eafinalproject.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {

    @Query("Select a.job.interviewList from Application a where a.id= ?1")
    List<Interview> getByApplicationId(int applicationId);

    void deleteById(int id);

}
