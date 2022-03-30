package com.example.eafinalproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DeleteLoggingAspect {

    @Pointcut("execution(* com.example.eafinalproject.repository.ApplicationRepository.deleteById(..))")
    public void applicationDeleted() {
    }

    @Pointcut("execution(* com.example.eafinalproject.repository.CompanyRepository.deleteById(..))")
    public void companyDeleted() {
    }

    @Pointcut("execution(* com.example.eafinalproject.repository.InterviewRepository.deleteById(..))")
    public void interviewDeleted() {
    }

    @Pointcut("execution(* com.example.eafinalproject.repository.JobRepository.deleteById(..))")
    public void jobDeleted() {
    }

    @Pointcut("execution(* com.example.eafinalproject.repository.SkillRepository.deleteById(..))")
    public void skillDeleted() {
    }

    @After("applicationDeleted() || companyDeleted() || interviewDeleted() || jobDeleted() || skillDeleted()")
    public void afterDeletingApplication(JoinPoint joinPoint) {
        System.out.println("Object type of " + joinPoint.getSignature().getDeclaringTypeName() + " - using method "
                + joinPoint.getSignature().getName() + " with id " + joinPoint.getArgs()[0] +
                " deleted Successfully.");
    }


}
