package com.example.exam3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class HouseDeleteLoggingAspect {

    @After("execution(* com.example.exam3.repository.HouseRepository.deleteById(..))")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("House Repository "+joinPoint.getSignature().getDeclaringTypeName()+" - "
                +joinPoint.getSignature().getName() + "method ended Successfully.");
        System.out.println("House with id:"+joinPoint.getArgs()[0].toString()+" deleted Successfully.");
    }

}
