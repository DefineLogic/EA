package com.example.eafinalproject.repository;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill,Integer> , JpaSpecificationExecutor<Skill> {

    public Optional<Skill> findById(int id);

    @Query("Select a.job.skillList from Application a where a.id= ?1")
    List<Skill> findByApplicationId(int applicationId);

    void deleteById(int id);
}
