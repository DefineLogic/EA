package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Interview;
import com.example.eafinalproject.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("applications/{applicationId}/interviews")
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @GetMapping
    public List<Interview> getInterviews(@PathVariable int applicationId) {
        return interviewService.getInterviews(applicationId);
    }

    @DeleteMapping
    public void deleteInterviews(@PathVariable int applicationId) {
        interviewService.deleteInterviews(applicationId);
    }

    @PostMapping
    public void addInterviews(@PathVariable int applicationId, @RequestBody List<Interview> interviewDetails) {
        interviewService.addInterviews(applicationId, interviewDetails);
    }

    @PutMapping
    public void updateInterviews(@PathVariable int applicationId, @RequestBody List<Interview> interviewDetails) {
        interviewService.updateInterviews(applicationId, interviewDetails);
    }

}
