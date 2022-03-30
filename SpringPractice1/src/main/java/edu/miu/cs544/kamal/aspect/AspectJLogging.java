package edu.miu.cs544.kamal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class AspectJLogging {

    @Before("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.connect(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("Starting "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
    }

    @After("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.*(..))")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("Ended "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());

    }

    @Around("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Before "+proceedingJoinPoint.getSignature().getDeclaringTypeName()+"-"+proceedingJoinPoint.getSignature().getName());
        if(Math.random()>0.5){
        proceedingJoinPoint.proceed();}
        else{
                System.out.println("Didn't call the joinpoint.");
        }
        System.out.println("Around After "+proceedingJoinPoint.getSignature().getDeclaringTypeName()+"-"+proceedingJoinPoint.getSignature().getName());


    }
}
