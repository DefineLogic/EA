package com.example.eafinalproject.repository;

import com.example.eafinalproject.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Integer>,
        JpaSpecificationExecutor<Application> {

        public Optional<Application> findById(int id);

        public void deleteById(int id);


}
