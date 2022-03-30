//package edu.miu.cs544.kamal.aspect;
//
//import org.springframework.aop.AfterReturningAdvice;
//import org.springframework.aop.MethodBeforeAdvice;
//
//import java.lang.reflect.Method;
//
//public class SpringAopLogging implements MethodBeforeAdvice, AfterReturningAdvice {
//
//
//    @Override
//    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
//        System.out.println("Ended"+o.getClass()+"-"+method.getName());
//
//    }
//
//    @Override
//    public void before(Method method, Object[] objects, Object o) throws Throwable {
//        System.out.println("Starting"+o.getClass()+"-"+method.getName());
//
//    }
//}
