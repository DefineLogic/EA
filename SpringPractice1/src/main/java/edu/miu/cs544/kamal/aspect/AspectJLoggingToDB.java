//package edu.miu.cs544.kamal.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.core.annotation.Order;
//
//@Aspect
//@Order(2)
//public class AspectJLoggingToDB {
//
//    @Before("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.*(..))")
//    public void before(JoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting db "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.*(..))")
//    public void afterReturning(JoinPoint joinPoint) throws Throwable {
//        System.out.println("Ended db "+joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
//
//    }
//
//    @Around("execution(* edu.miu.cs544.kamal.service.DatabaseConnection.*(..))")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Around Before db "+proceedingJoinPoint.getSignature().getDeclaringTypeName()+"-"+proceedingJoinPoint.getSignature().getName());
//        if(Math.random()>0.5){
//        proceedingJoinPoint.proceed();}
//        else{
//                System.out.println("Didn't call the joinpoint db.");
//        }
//        System.out.println("Around After db "+proceedingJoinPoint.getSignature().getDeclaringTypeName()+"-"+proceedingJoinPoint.getSignature().getName());
//    }
//}
