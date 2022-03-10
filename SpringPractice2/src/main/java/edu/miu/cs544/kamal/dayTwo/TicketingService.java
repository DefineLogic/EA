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

public class TicketingService implements InitializingBean,DisposableBean, BeanNameAware, ResourceLoaderAware,
        ApplicationContextAware {

    private PrintService printService;

    public TicketingService(PrintService printService) {
        System.out.println("TicketingService constructor called.");
        this.printService = printService;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TicketingService destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TicketingService afterPropertiesSet method called");

    }

    public void doPrint(){
        printService.printMessage("1234");
    }

    public void customInit(){
        System.out.println("TicketingService customInit method called.");
    }

    public void customDestroy(){
        System.out.println("TicketingService customDestroy method called.");
    }

    @PostConstruct
    public void customInit2(){
        System.out.println("TicketingService PostConstruct method called.");
    }

    @PreDestroy
    public void customDestroy2(){
        System.out.println("TicketingService PreDestroy method called.");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("TicketingService setBeanName method called."+s);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("TicketingService setResourceLoader method called."+resourceLoader);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("TicketingService setApplicationContext method called."+applicationContext);
    }
}
