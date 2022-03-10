package edu.miu.cs544.kamal.dayTwo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrintService implements InitializingBean,DisposableBean, BeanNameAware , ResourceLoaderAware
        , ApplicationContextAware {

    public PrintService(){
        System.out.println("PrintService constructor called.");
    }

    public void printMessage(String ticketNo){
        System.out.println("Printing the ticket...."+ticketNo);
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("PrintService destroy method called.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PrintService afterPropertiesSet method called.");
    }

    public void customInit(){
        System.out.println("PrintService customInit method called.");
    }

    public void customDestroy(){
        System.out.println("PrintService customDestroy method called.");
    }

    @PostConstruct
    public void customInit2(){
        System.out.println("PrintService PostConstruct method called.");
    }

    @PreDestroy
    public void customDestroy2(){
        System.out.println("PrintService PreDestroy method called.");
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("PrintService setResourceLoader method called."+resourceLoader);

    }
    @Override
    public void setBeanName(String s) {
        System.out.println("PrintService setBeanName method called."+s);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PrintService setApplicationContext method called."+applicationContext);
    }
}
