package edu.miu.cs544.kamal.dayTwo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        TicketingService ticketingService = (TicketingService) springContext.getBean("ts");

//        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        TicketingService ticketingService = springContext.getBean(TicketingService.class);
        ticketingService.doPrint();
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) springContext;
        configurableApplicationContext.close();


    }
}
