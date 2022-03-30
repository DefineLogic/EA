package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public List<Application> getApplications(){
        return applicationService.getAllApplication();
    }


    @GetMapping("/{applicationId}")
    public Application getApplication(@PathVariable int applicationId){
        return applicationService.getApplication(applicationId);
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        Application savedApplication = applicationService.save(application);
        long savedApplicationId = savedApplication.id;
        URI saveApplicationUri =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{applicationId}")
                        .buildAndExpand(savedApplicationId).toUri();
        return ResponseEntity.created(saveApplicationUri).build();
    }

    @DeleteMapping("/{applicationId}")
    public void deleteApplication(@PathVariable int applicationId){
        applicationService.deleteApplication(applicationId);
    }

    @RequestMapping(value="/{applicationId}",method=RequestMethod.PUT)
    public ResponseEntity<Application> updateApplication(@PathVariable int applicationId,
                                                         @RequestBody Application applicationDetails){
        Application application = applicationService.getApplication(applicationId);
        application.setJob(applicationDetails.getJob());
        Application updatedApplication = applicationService.save(application);
        return ResponseEntity.ok(updatedApplication);
    }

}
