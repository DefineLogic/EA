package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Skill;
import com.example.eafinalproject.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("applications/{applicationId}/skills")
@RestController
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping
    public List<Skill> getSkills(@PathVariable int applicationId){
        return skillService.getSkills(applicationId);
    }

    @DeleteMapping
    public void deleteSkills(@PathVariable int applicationId){
        skillService.deleteSkills(applicationId);
    }

    @PostMapping
    public void addSkills(@PathVariable int applicationId, @RequestBody List<Skill> skillDetails){
        skillService.addSkills(applicationId,skillDetails);
    }

    @PutMapping
    public void updateSkills(@PathVariable int applicationId, @RequestBody List<Skill> skillDetails){
        skillService.updateSkills(applicationId,skillDetails);
    }
}
