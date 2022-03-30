package com.example.eafinalproject.service;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.entities.Skill;
import com.example.eafinalproject.exception.ExceptionHandler;
import com.example.eafinalproject.repository.ApplicationRepository;
import com.example.eafinalproject.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    public List<Skill> getSkills(int applicationId) {
        return skillRepository.findByApplicationId(applicationId);
    }

    public void deleteSkills(int applicationId) {
        try {
            Application application = applicationRepository.getById(applicationId);
            if (application != null && application.getJob() != null) {
                List<Skill> skillList = application.getJob().getSkillList();
                application.getJob().setSkillList(null);
                applicationRepository.save(application);
                for (Skill skill : skillList) {
                    skillRepository.deleteById(skill.id);
                }
            }
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);

        }
    }

    public void updateSkills(int applicationId, List<Skill> skillDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            application.getJob().setSkillList(skillDetails);
            applicationRepository.save(application);
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

    public void addSkills(int applicationId, List<Skill> skillDetails) {
        try {
            Application application = applicationRepository.getById(applicationId);
            application.getJob().getSkillList().addAll(skillDetails);
            applicationRepository.save(application);
        } catch (EntityNotFoundException e) {
            ExceptionHandler.handleException("Application not found for Id:" + applicationId);
        }
    }

}
